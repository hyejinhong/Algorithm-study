package algospot;

import java.util.*;

public class QuadTree {
	
	static String str;
	static int index;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		scan.nextLine();
		for(int test=1; test<=c; test++) {
			str = scan.nextLine().trim();
			index = 0;
			String result = reverse();
			System.out.println(result);
		}
	}
	
	public static String reverse() {
		// 기저: 전체가 같은 색인 경우
		char c = str.charAt(index);
		if(c == 'b' || c == 'w') {
			return Character.toString(c);
		}
		
		index++;
		String piece2 = reverse();
		index++;
		String piece1 = reverse();
		index++;
		String piece3 = reverse();
		index++;
		String piece4 = reverse();
		
		return "x" + piece3 + piece4 + piece2 + piece1;
	}
}
