package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Nerd2 {

	static int n;
	static TreeMap<Integer, Integer> tree = new TreeMap<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=c; test++) {
			n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				checkNerds(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			}
			
			System.out.println(result);
			tree.clear();
			result = 0;
		}
	}
	
	// 새로운 점 (x, y)가 기존의 다른 점들에 의해 지배당하는지 확인한다.
	public static boolean isDominated(int x, int y) {
		// x보다 오른쪽에 있는 점 중 가장 왼쪽에 있는 점을 찾는다.
		Integer key = tree.ceilingKey(x); // x를 기준으로 오른쪽 서브트리에서 가장 왼쪽 원소 (큰 것중에 가장 작은 것)
		
		if(key != null && y < tree.get(key)) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public static void checkNerds(int x, int y) {
		// 지배당하는 건 버린다.
		if(isDominated(x, y)) {
			result += tree.size();
			return;
		}
		
		// 지배당하는 좌표들을 모두 지움
		Integer key = tree.floorKey(x); // x를 기준으로 왼쪽 서브트리에서 가장 오른쪽 원소 (작은 것중에 제일 큰 것)
		while(key != null) {
			// x좌표도 작고 y좌표도 작음 -> 지워
			if(tree.get(key) < y) {
				tree.remove(key);
			}
			else {
				break;
			}
			key = tree.floorKey(key);
		}
		
		tree.put(x, y);
		result += tree.size();
	}


}
