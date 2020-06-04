package programmers;

public class MakeWeirdString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "try hello world";
		System.out.println(solution(s));
	}

    public static String solution(String s) {
        int index = 0;
        
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            
            // �����̸� index �ʱ�ȭ
            if(ch == ' ') {
                index = 0;
                continue;
            }
            
            // ���� �ƴϸ� index�� ���� �ٲ�
            // ¦��: �ҹ��� -> �빮��
            if(index%2 == 0) {
                if(ch >= 'a' && ch <= 'z') {
                    ch += ('A' - 'a');
                }
            }
            // Ȧ��: �빮�� -> �ҹ���
            else {
                if(ch >= 'A' && ch <= 'Z') {
                    ch -= ('A' - 'a');
                }
            }
            index++;
            sb.setCharAt(i, ch);
        }
    
        return sb.toString();
    }
}
