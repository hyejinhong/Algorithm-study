package programmers;

public class JoyStick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String name = "JEROEN";
		String name = "JAN";
//		String name = "ABABAAAAAAABA";
//		String name = "BBAABAAAB";
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int n = name.length();
		
		// init
		String str = "";
		for(int i=0; i<n; i++) {
			str += "A";
		}
		
		// �� ���ڸ� �ش� �ڸ��� ���ڷ� �ٲ� �� �ִ� ���� ���� Ƚ������ ���ϸ� ��.
		
		char[] arr = str.toCharArray();

		// �� ���� ���� �ּ�
		int sum = 0;
		for(int i=0; i<n; i++) {
			char src = arr[i];
			char target = name.charAt(i);
			sum += change(src, target);
		}
		
		// �¿� �̵� �ּҰ� ã��
		int move = name.length()-1;
		for(int i=0; i<n; i++) {
			// �ٲ���� ���ڰ� A�� �ƴ� ��쿡�� ������ �̵�
			if(name.charAt(i) != 'A') {
				int next = i+1;
				while(next < name.length() && name.charAt(next) == 'A') {
					next++;
				}
				int temp = 2 * i + name.length() - next;
				move = Math.min(move, temp);
			}
		}
		
		return move + sum;
	}
	
	// src�� target���� ����� �ּ� Ƚ���� ��ȯ��
	public static int change(char src, char target) {
		int count1 = Math.abs(target - src);
		int count2 = Math.abs((src-'A') + ('Z'-target) + 1);
		
		return Math.min(count1, count2);
	}
}
