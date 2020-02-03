package algospot;

import java.util.*;

public class StrJoin {
	
	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			for(int i=0; i<n; i++) {
				list.add(scan.nextInt());
			}
			
			System.out.println(concat());
			list.clear();
		}
	}
	
	// ���ڿ����� ���̰� �־��� �� �ϳ��� ��ġ�� �ּ� ��� ��ȯ
	// ���� ���̰� ª�� �ͺ��� ���ϰ�, ���� ���� ����Ʈ �ڿ� �߰��� -> priority queue
	public static int concat(){
		int temp = 0;
		int cost = 0;
		
		while(list.size() > 1) {
			Collections.sort(list);
			temp = list.get(0) + list.get(1);
			cost += temp;
			list.add(temp);
			list.remove(0);
			list.remove(0);

		}

		return cost;
	}

}
