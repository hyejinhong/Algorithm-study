package programmers;

public class GymClothes {

	static int[] st;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ns = {5, 5, 3, 10, 7};
		int[][] lost = { {2, 4}, {2, 4}, {3}, {1}, {4, 5} };
		int[][] reserve = { {1, 3, 5}, {3}, {1}, {3}, {1, 5}};
		for(int i=0; i<ns.length; i++) {
			System.out.println(solution(ns[i], lost[i], reserve[i]));
		}
	}

	public static int solution(int n, int[] lost, int[] reserve) {
        // init
        st = new int[n+1];
        for(int i=1; i<=n; i++) {
            st[i] = 1;
        }
        
        // input
        for(int i=0; i<lost.length; i++) {
            int index = lost[i];
            st[index]--;
        }
        for(int i=0; i<reserve.length; i++) {
            int index = reserve[i];
            st[index]++;
        }
        
        // ������
        for(int i=1; i<=n; i++) {
            // ���� �л��� ü������ ���� �л��̸�
            if(st[i] == 0) {
                // �յڿ��� ������ ��� ������ ������
                for(int j=-1; j<=1; j+=2) {
                    int index = i+j;
                    // index range check
                    if(index <= 0 || index > n) {
                        continue;
                    }
                    if(st[index] == 2) {
                        st[index]--;
                        st[i]++;
                        break;
                    }
                }
            }
        }
        
        int answer = 0;
        // ü���� 1�� �̻��̸� ������ ���� �� ����
        for(int i=0; i<st.length; i++) {
            if(st[i] != 0) {
                answer++;
            }
        }
        return answer;
	}
}
