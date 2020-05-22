package programmers;

public class MakingJadenCaseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {
//				"3people unFollowed me",
//				"for the last week",
				"  for the last week  ",
				"SHINEE  WORLD    nknk",
				"s",
				"5may 25Th",
				"3T"
		};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}

	public static String solution(String s) {
		String[] arr = s.toLowerCase().split("");
		String answer = "";
		
		boolean flag = true;
		
		for(String word : arr) {
			answer += flag ? word.toUpperCase() : word;
			flag = word.equals(" ") ? true : false;
		}

		return answer;
	}
}
