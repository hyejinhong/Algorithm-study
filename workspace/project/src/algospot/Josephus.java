package algospot;

import java.util.*;
public class Josephus {
	
	static int n;
	static int k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			k = scan.nextInt();
			System.out.println(josephus());
		}
	}

	public static String josephus() {
		LinkedList<Integer> survivors = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			survivors.add(i);
		}
	
		// �̹��� ���� ����� ��Ÿ���� ������
		Iterator<Integer> kill = survivors.iterator(); // head�� ��ȯ�ϹǷ�
		kill.next(); // �ѹ� next ���ְ� ����
		
		while(n > 2) {
			kill.remove();
			if(!kill.hasNext()) {
				kill = survivors.iterator();
			}
			kill.next();
			n--;
			
			// k-1�� ���� ������� �ű�
			for(int i=0; i<k-1; i++) {
				if(!kill.hasNext()) {
					kill = survivors.iterator();
				}
				kill.next();
			}
		}
		return survivors.getFirst().toString() + " " + survivors.getLast().toString();
	}
}
