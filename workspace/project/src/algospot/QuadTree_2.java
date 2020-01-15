package algospot;

import java.util.*;

public class QuadTree_2 {
	static String str;
	static int index;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int c = scan.nextInt();
		scan.nextLine();
		
		for(int test=1; test<=c; test++) {
			str = scan.nextLine();
			index = 0;
			System.out.println(reverse());
		}
	}
	
	public static String reverse() {
		// 기저: 모든 칸이 같은 색
		char c = str.charAt(index);
		if(c == 'b' || c == 'w') {
			return Character.toString(c);
		}
		
		// 1 -> 3
		// 2 -> 4
		// 3- > 1
		// 4 -> 2
		
		index++;
		String piece1 = reverse();
		index++;
		String piece2 = reverse();
		index++;
		String piece3 = reverse();
		index++;
		String piece4 = reverse();
		
		return "x" + piece3 + piece4 + piece1 + piece2;
	}
	

}
