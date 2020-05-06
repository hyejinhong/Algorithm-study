package programmers;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaaaaabbbbbbbbbb";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int answer = s.length();
		
		for(int unit=1; unit<=s.length()/2; unit++) {
			int result = compress(s, unit);
			answer = Math.min(answer, result);
		}
		return answer;
	}
	
	// unit������ �߶� �������� ���� ���ڿ� ���� ��ȯ
	public static int compress(String s, int unit) {
		StringBuilder sb = new StringBuilder();
		String temp = s.substring(0, unit);
		
		int index = unit;
		int count = 1;
		
		while(true) {
			
			if(index + unit > s.length()) {
				// ���� �����ִ� �� ����
				if(count == 1) {
					sb.append(temp);
				}
				else {
					sb.append(count + temp);
				}
				sb.append(s.substring(index));
				break;
			}
			
			String cur = s.substring(index, index+unit);
			// ���� ���ְ� ������
			if(cur.equals(temp)) {
				count++;
			}
			// �ٸ���
			else {
				if(count == 1) {
					sb.append(temp);
				}
				else {
					sb.append(count + temp);
				}
				temp = cur;
				count = 1;
			}
			index += unit;
		}
		
//		String result = sb.toString().replace("1", "");
		String result = sb.toString();
		System.out.println("unit: " + unit + ", result: " + result + ", length: " + result.length());
		return result.toString().length();
	}
}
