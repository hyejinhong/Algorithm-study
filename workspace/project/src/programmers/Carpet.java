package programmers;

import java.util.Arrays;

public class Carpet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] brown = {10, 8, 24};
		int[] yellow = {2, 1, 24};
		for(int i=0; i<brown.length; i++) {
			System.out.println(Arrays.toString(solution(brown[i], yellow[i])));
		}
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		for(int height=1; height<=5000; height++) {
			for(int width=height; width<=5000; width++) {
				int b = getBrown(width, height);
				int y = getYellow(width, height);
				
				if(b == brown && y == yellow) {
					answer[0] = width;
					answer[1] = height;
					return answer;
				}

			}
		}
		return answer;
	}
	
	public static int getBrown(int width, int height) {
		int ret = width*2 + (height-2)*2;
		return ret;
	}
	
	public static int getYellow(int width, int height) {
		int ret = (width-2) * (height-2);
		return ret;
	}
}
