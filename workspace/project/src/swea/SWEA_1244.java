package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1244 {

	static int[] card = new int[6];
	static int n;
	
	static int digit = 0; // 자릿수 저장	
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=c; test++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			
			digit = 0;
			max = 0;
			
			int index = 0;
			int[] temp = new int[6];
			
			// num -> card 배열로
			while(num > 0) {
				int d = num%10;
				temp[index++] = d;
				num /= 10;
			}
			
			digit = index;
			
			for(int i=index-1; i>=0; i--) {
				card[index-i-1] = temp[i];
			}
			
			swap(0, 0);
			
			System.out.println("#" + test + " " + max);
		}
	}
	
	public static void swap(int index, int count) {
		// 기저
		if(count == n) {
			int result = calculate();
			max = Math.max(max, result);
			return;
		}
		
		for(int i=index; i<digit; i++) {
			for(int j=i+1; j<digit; j++) {
				if(card[i] <= card[j]) {
					// swap
					int temp = card[i];
					card[i] = card[j];
					card[j] = temp;
					
					// 마저 ㄱㄱ
					swap(i, count+1);
					
					// 돌려놓기
					temp = card[i];
					card[i] = card[j];
					card[j] = temp;
				}
			}
		}
	}
	
	public static int calculate() {
		String str = "";
		
		for(int i=0; i<digit; i++) {
			str += card[i];
		}
		
		return Integer.parseInt(str);		
	}

}
