package programmers;

public class Year2016 {

	static int[] monthDays = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static String[] days = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] a = {5, 1};
    	int[] b = {24, 8};
    	
    	for(int i=0; i<a.length; i++) {
    		System.out.println(solution(a[i], b[i]));
    	}
	}

    public static String solution(int a, int b) {
        // 1�� 1���� �ݿ���
        int month = 1;
        int date = 1;
        int day = 5;

        // a�� b�ϰ� ��ĥ ���̰� ������ ���ϱ�
        int sum = -1;

        for(int i=0; i<a-month; i++) {
            sum += monthDays[month+i];
        }
        sum += b;

        // 7�� ���� ������ ..
        sum %= 7;

        String answer = days[sum];
        return answer;
    }
}
