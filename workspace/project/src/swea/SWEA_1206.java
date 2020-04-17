package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206 {

	static int length;
	static int[] h = new int[1000];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 10;
		StringTokenizer stk;
		
		for(int test=1; test<=c; test++) {
			stk = new StringTokenizer(br.readLine());
			length = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			for(int i=0; i<length; i++) {
				h[i] = Integer.parseInt(stk.nextToken());
			}
			System.out.println("#" + test + " " + solve());
		}
	}
	
	public static int solve() {
		int count = 0;
		
		for(int i=2; i<length-2; i++) {
			int height = h[i];
			int next = h[i+1];
			// 1. 오른쪽 건물이 나보다 높으면 안됨
			if(h[i] < h[i+1]) {
				continue;
			}
			
			// 양 옆 2칸 범위의 건물의 높이 중 높은 것 알아냄
			int nearMax = 0;
			for(int j=-2; j<=2; j++) {
				// 자기 자신과는 비교하지마셈
				if(j == 0) {
					continue;
				}
				nearMax = Math.max(nearMax, h[i+j]);
			}
			
			// 그 건물보다 높은 층들은 조망권이 확보된 것임
			if(h[i] > nearMax) {
				count += (h[i]- nearMax);
			}
		}
		
		return count;
	}

}
