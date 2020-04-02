package programmers;

public class Country124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		String answer = "";
		int remainder = 0;
		
		// n%3 == 0 -> 마지막 자리 4
		// n%3 != 0 -> 마지막 자리 3%n
		while(n > 0) {
			remainder = n%3;
			n /= 3;
			
			if(remainder == 0) {
				n -= 1;
				remainder = 4;
			}
			
			answer = remainder + answer;
		}
		
		System.out.println(answer);
	}

}
