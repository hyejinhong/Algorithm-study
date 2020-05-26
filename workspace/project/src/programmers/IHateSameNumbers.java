package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class IHateSameNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{1,1,3,3,0,1,1}, {4,4,4,3,3}
		};
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(solution(arr[i])));
		}
	}

	public static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            int number = arr[i];
            
            if(arr[i-1] != number) {
                list.add(number);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
	}
}
