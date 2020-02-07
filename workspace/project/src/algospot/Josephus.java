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
	
		// 이번에 죽을 사람을 나타내는 포인터
		Iterator<Integer> kill = survivors.iterator(); // head를 반환하므로
		kill.next(); // 한번 next 해주고 시작
		
		while(n > 2) {
			kill.remove();
			if(!kill.hasNext()) {
				kill = survivors.iterator();
			}
			kill.next();
			n--;
			
			// k-1번 다음 사람으로 옮김
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
