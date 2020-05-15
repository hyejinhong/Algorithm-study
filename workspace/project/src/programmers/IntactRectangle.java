package programmers;

public class IntactRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {		
		long sum = 0;
		for(int x=0; x<w; x++) {
			long y = exp(w, h, x);

			sum += y;
		}

		return sum * 2;
	}
	
	// 직선의 방정식
	public static long exp(double w, double h, int x) {
		double temp = h / w;
		long y = (long) (temp * x);
//		long y = Long.valueOf(h) * x / Long.valueOf(w);

		return y;
	}
}
