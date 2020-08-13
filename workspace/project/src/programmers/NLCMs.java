package programmers;

public class NLCMs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
//				{2, 6, 8, 14},
//				{1, 2, 3},
//				{2, 3, 4},
				{14, 2, 7}
		};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(solution(arr[i]));
//			System.out.println(getLCM(9, 30));
		}
	}

	
	public static int solution(int[] arr) {
		int result = arr[0];
		for(int i=1; i<arr.length; i++) {
			int cur = arr[i];
			
			// mem�� cur�� �ּ� ������� ����
			result = getLCM(result, cur);
		}
		
		return result;
	}
	
	// �ּҰ����
	public static int getLCM(int num1, int num2) {
		// 9, 30
		
		int lcm = 1;
		
		while(true) {
			// �� ���� �ִ������� ���Ѵ�
			int gcd = getGCD(num1, num2);
			
			// �ִ����� 1�̸�
			if(gcd == 1) {
				lcm *= num1 * num2;
				break;
			}
			
			// �ƴϸ�
			lcm *= gcd;
			num1 /= gcd;
			num2 /= gcd;
		}

		return lcm;
	}
	
	// �ִ�����
	public static int getGCD(int num1, int num2) {
		// 9, 30
		int gcd = 1;
		
		for(int i=gcd; i<=num1 && i<=num2; i++) {
			// ������� gcd ����
			if(num1%i == 0 && num2%i == 0) {
				gcd = i;
			}
		}
		
		return gcd;
	}
}
