package programmers;

public class MakingLargeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] number = { "1924", "1231234", "4177252841" };
		int[] k = { 2, 3, 4 };
		for(int i=0; i<number.length; i++) {
			System.out.println(solution(number[i], k[i]));
		}
	}

	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		
		// �� �ڿ� �ִ� ���ڰ� ������ ũ�� ���� ���ش�.
		int count = 0;
		int index = 1;
        
		while(count < k) {
			if(index >= 1 && sb.charAt(index) > sb.charAt(index-1)) {
				sb.deleteCharAt(index-1);
				index--;
				count++;
			}
			else {
				if(index == sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)) {
					sb.deleteCharAt(index);
					count++;
					index--;
				}
				else {
					index++;
				}
			}
		}
				
		return sb.toString();
	}
}
