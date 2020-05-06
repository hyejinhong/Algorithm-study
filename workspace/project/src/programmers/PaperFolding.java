package programmers;

import java.util.Arrays;

public class PaperFolding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(Arrays.toString(solution(n)));
	}

	public static int[] solution(int n) {
		if(n == 1) {
			int[] answer = { 0 };
			return answer;
		}
		
		String result = "";
		
		for(int i=1; i<=n; i++) {
			result = calculate(i, result);
		}
		
		int[] answer = new int[result.length()];
		for(int i=0; i<result.length(); i++) {
			answer[i] = Integer.parseInt(result.substring(i, i+1));
		}
		
		return answer;
	}
	
	public static String calculate(int i, String str) {
		StringBuilder ret = new StringBuilder(str);
		
		if(i == 1) {
			return "0";
		}
		else {
			ret.append("0");
			String[] temp = str.split("");
			
			for(int j=temp.length-1; j>=0; j--) {
				String piece = temp[j].equals("0") ? "1" : "0";
				ret.append(piece);
			}
		}
		return ret.toString();
	}
}
