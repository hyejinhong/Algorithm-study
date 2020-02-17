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
	
	// ���ο� �� (x, y)�� ������ �ٸ� ���鿡 ���� ������ϴ��� Ȯ���Ѵ�.
	public static boolean isDominated(int x, int y) {
		// x���� �����ʿ� �ִ� �� �� ���� ���ʿ� �ִ� ���� ã�´�.
		Integer key = tree.ceilingKey(x); // x�� �������� ������ ����Ʈ������ ���� ���� ���� (ū ���߿� ���� ���� ��)
		
		if(key != null && y < tree.get(key)) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public static void checkNerds(int x, int y) {
		// ������ϴ� �� ������.
		if(isDominated(x, y)) {
			result += tree.size();
			return;
		}
		
		// ������ϴ� ��ǥ���� ��� ����
		Integer key = tree.floorKey(x); // x�� �������� ���� ����Ʈ������ ���� ������ ���� (���� ���߿� ���� ū ��)
		while(key != null) {
			// x��ǥ�� �۰� y��ǥ�� ���� -> ����
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
