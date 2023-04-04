package programmers;

public class 마법의엘리베이터 {

	public static void main(String[] args) {
		마법의엘리베이터 instance = new 마법의엘리베이터();
//		int storey = 16; // 6
//		int storey = 2554; // 16
		int storey = 1051;

		System.out.println(instance.solution(storey));
	}

	public int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int digit = storey % 10;
			storey /= 10;

			// 5인 경우, 앞자리 숫자가 6이상이면 올려주는 것이 유리함.
			if (digit == 5) {
				if (storey%10 >= 6) {
					answer += (10 - digit);
					storey++;
				}
				else {
					answer += digit;	
				}
			}
			// 더하는 것이 이득
			else if (digit > 5) {
				answer += (10 - digit);
				storey++;
			}
			// 빼는 것이 이득
			else {
				answer += digit;
			}

		}
		return answer;
	}

}
