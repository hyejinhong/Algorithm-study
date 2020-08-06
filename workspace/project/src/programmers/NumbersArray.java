package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{ 5, 9, 7, 10 },
				{ 2, 36, 1, 3 },
				{ 3, 2, 6}
		};
		
		int[] divisor = {
				5, 1, 10
		};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(solution(arr[i], divisor[i])));
		}
	}
	
	public static int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> list = new ArrayList<>();
		
		// n
		for(int i=0; i<arr.length; i++) {
			int num = arr[i];
			
			// ³ª´©¾î ¶³¾îÁü
			if(num%divisor == 0) {
				list.add(num);
			}
		}

		int[] answer;
		
		// ³ª´©¾î ¶³¾îÁö´Â ¿ø¼Ò ¾øÀ½
		if(list.isEmpty()) {
			answer = new int[1];
			answer[0] = -1;
		}
		else {
			answer = new int[list.size()];
			
			// n
			for(int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
		}
		
		// ÃÑ 2n
		Arrays.sort(answer);
		return answer;
	}

}
