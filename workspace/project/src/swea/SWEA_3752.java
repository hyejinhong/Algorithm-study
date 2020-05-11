package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3752 {

	static int n;
	static int[] scores = new int[101];
	
	static boolean[] check = new boolean[10001];
	static int[] cache = new int[101];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine());
			Arrays.fill(cache, -1);
			
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				scores[i] = Integer.parseInt(stk.nextToken());
			}
			
			int max = 0;
			check[0] = true;
			
			for(int index=1; index<=n; index++) {
				max = getMaxSum(index);
				
				for(int score=max; score>=0; score--) {
					
					// ���� ����� ������ �� ������ ���� ���� true�� ��ũ����
					if(check[score]) {
						check[score+scores[index]] = true;
					}
				}
				check[max] = true;
			}
			
			int count = 0;
			for(int i=0; i<=max; i++) {
				if(check[i]) {
					count++;
				}
			}
			
			Arrays.fill(check, false);
			System.out.println("#" + test + " " + count);
			
		}
	}
	
	// index���� ������ �ְ� �� ��ȯ
	public static int getMaxSum(int index) {
		if(index == 0) {
			return 0;
		}
		
		// ĳ�ð� �ִٸ�
		if(cache[index] != -1) {
			return cache[index];
		}
		
		cache[index] = getMaxSum(index-1) + scores[index];
		return cache[index];
	}


}
