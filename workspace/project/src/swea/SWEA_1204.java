package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1204 {

	static int[] arr = new int[101];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		
		for(int test=1; test<=t; test++) {
			Arrays.fill(arr, 0);
			int tn = Integer.parseInt(br.readLine());
			
			stk = new StringTokenizer(br.readLine());
			for(int i=0; i<1000; i++) {
				int score = Integer.parseInt(stk.nextToken());
				arr[score]++;
			}
		
			System.out.println("#" + tn + " " + getResult());
		}
	}
	
	// 최빈값 점수 반환
	public static int getResult() {
		int maxFreq = 0; // 가장 높은 빈도
		int ret = 0;
		
		for(int score=0; score<=100; score++) {
			int freq = arr[score];
			if(freq >= maxFreq) {
				maxFreq = freq;
				ret = score;
			}
		}
		return ret;
	}

}
