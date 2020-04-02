package programmers;

import java.util.Arrays;

public class Top {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,5,3,6,7,6,5};
		int[] answer = new int[heights.length];
		
//		Stack<Integer> stack = new Stack<>();
		
		for(int i=heights.length-1; i>0; i--) {
			// 왼쪽 탑에 수신 가능
			if(heights[i-1] > heights[i]) {
				answer[i] = (i-1) + 1;
			}
			// 수신 못하면 왼쪽으로 가면서 높은 탑 찾음
			else {
				for(int j=i-1; j>=0; j--) {
					// 왼쪽 탑에 수신 가능
					if(heights[j] > heights[i]) {
						answer[i] = j+1;
						break;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
