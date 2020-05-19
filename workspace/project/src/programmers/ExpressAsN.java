package programmers;

public class ExpressAsN {

	static int min = -1;
	static int[] nn = new int[8];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}

	public static int solution(int N, int number) {
		// init
		String str = "";
		for(int i=0; i<8; i++) {
			for(int j=0; j<=i; j++) {
				str += N;
			}
			nn[i] = Integer.parseInt(str);
			str = "";
		}
		
		express(N, 0, number, 0);
		return min;
	}
	
	public static void express(int N, int cur, int number, int count) {
		if(count > 8) {
			return;
		}
		if(cur == number) {
			if(count < min || min == -1) {
				min = count;
			}
			return;
		}
		
		for(int i=0; i<8; i++) {
			int NN = nn[i];
			
			express(N, cur+NN, number, count+i+1);
			express(N, cur-NN, number, count+i+1);
			express(N, cur*NN, number, count+i+1);
			express(N, cur/NN, number, count+i+1);
		}
	}
	
}
