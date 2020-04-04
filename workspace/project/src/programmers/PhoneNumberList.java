package programmers;

public class PhoneNumberList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {
				"123", "456", "789"
		};
		
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if(i == j) {
					continue;
				}
				if(phone_book[j].indexOf(phone_book[i]) == 0) {
					return false;
				}
			}
		}
		return answer;
	}
}
