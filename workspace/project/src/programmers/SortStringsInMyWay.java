package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringsInMyWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] strings = {
				{"sun", "bed", "car"},
				{"abce", "abcd", "cdx"}
		};
		
		int[] n = {
				1, 2
		};
		
		for(int i=0; i<strings.length; i++) {
			System.out.println(Arrays.toString(solution(strings[i], n[i])));
		}
	}

	public static String[] solution(String[] strings, int n) {
	      String[] answer = new String[strings.length];
	      
	      for(int i=0; i<strings.length; i++) {
	          answer[i] = strings[i];
	      }
	      
	      Arrays.sort(answer, new Comparator<String>() {
	       
	    	  @Override
	          public int compare(String o1, String o2) {
	              return o1.charAt(n) - o2.charAt(n);
	          }
	      });
	      
	      return answer;
	}
}
