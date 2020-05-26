package programmers;

import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		};
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0]-1;
            int j = commands[a][1]-1;
            int k = commands[a][2];
            
            if(i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            
            int size = Math.abs(j-i)+1;
            int[] subArr = new int[size];
            for(int b=0; b<size; b++) {
                subArr[b] = array[b+i];
            }
            
            Arrays.sort(subArr);
            answer[a] = subArr[k-1];
        }

        return answer;
	}
}
