package programmers;

import java.util.Arrays;

public class Top {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,5,3,6,7,6,5};
		int[] answer = new int[heights.length];
		
//		Stack<Integer> stack = new Stack<>();
		
		for(int i=heights.length-1; i>0; i--) {
			// ���� ž�� ���� ����
			if(heights[i-1] > heights[i]) {
				answer[i] = (i-1) + 1;
			}
			// ���� ���ϸ� �������� ���鼭 ���� ž ã��
			else {
				for(int j=i-1; j>=0; j--) {
					// ���� ž�� ���� ����
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
