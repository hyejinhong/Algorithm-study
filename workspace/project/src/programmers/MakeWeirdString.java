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
            
            // 공백이면 index 초기화
            if(ch == ' ') {
                index = 0;
                continue;
            }
            
            // 공백 아니면 index에 따라 바꿈
            // 짝수: 소문자 -> 대문자
            if(index%2 == 0) {
                if(ch >= 'a' && ch <= 'z') {
                    ch += ('A' - 'a');
                }
            }
            // 홀수: 대문자 -> 소문자
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
