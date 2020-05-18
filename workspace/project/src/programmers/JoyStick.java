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
		
		// 각 글자를 해당 자리의 글자로 바꿀 수 있는 가장 작은 횟수들을 더하면 됨.
		
		char[] arr = str.toCharArray();

		// 각 글자 변경 최소
		int sum = 0;
		for(int i=0; i<n; i++) {
			char src = arr[i];
			char target = name.charAt(i);
			sum += change(src, target);
		}
		
		// 좌우 이동 최소값 찾기
		int move = name.length()-1;
		for(int i=0; i<n; i++) {
			// 바꿔야할 글자가 A가 아닌 경우에는 옆으로 이동
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
	
	// src를 target으로 만드는 최소 횟수를 반환함
	public static int change(char src, char target) {
		int count1 = Math.abs(target - src);
		int count2 = Math.abs((src-'A') + ('Z'-target) + 1);
		
		return Math.min(count1, count2);
	}
}
