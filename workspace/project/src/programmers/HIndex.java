package programmers;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		int n = citations.length;

		for(int h=1; h<=n; h++) {
			int count = 0;
			for(int i=0; i<n; i++) {
				if(citations[i] >= h) {
					count++;
				}
			}
			
			if(count >= h) {
				answer = Math.max(answer, h);
			}
		}
		return answer;
	}
}
