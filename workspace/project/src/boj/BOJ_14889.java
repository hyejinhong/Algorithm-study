package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889 {

	static int n;
	static int[][] s = new int[21][21];
	
	static boolean[] check = new boolean[21];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk;
		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				s[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		group(1, 0);
		System.out.println(min);
	}
	
	
	// n/2���� ����, ���ݱ��� num�� ����
	public static void group(int index, int num) {
		// ����: n/2���� �� �̾���
		if(num == n/2) {
			calculate();
			return;
		}
		
		for(int i=index; i<=n; i++) {
			if(!check[i]) {
				check[i] = true;
				
				group(i+1, num+1);
				check[i] = false;
			}
		}
	}
	
	// �ɷ�ġ ���
	public static void calculate() {
		// �� ������
		int[] team1 = new int[n/2]; // check == true�� ��
		int[] team2 = new int[n/2]; // check == false�� ��
		
		int count1 = 0;
		int count2 = 0;
		
		for(int i=1; i<=n; i++) {
			if(check[i]) {
				team1[count1++] = i;
			}
			else {
				team2[count2++] = i;
			}
		}
		
		int score1 = 0;
		int score2 = 0; 
		
		// team1 ���� ���
		for(int i=0; i<n/2; i++) {
			for(int j=i+1; j<n/2; j++) {
				int index1 = team1[i];
				int index2 = team1[j];
				
				score1 += s[index1][index2];
				score1 += s[index2][index1];
			}
		}
		
		// team2 ���� ���		
		for(int i=0; i<n/2; i++) {
			for(int j=i+1; j<n/2; j++) {
				int index1 = team2[i];
				int index2 = team2[j];
				
				score2 += s[index1][index2];
				score2 += s[index2][index1];
			}
		}
		
		// ���� ���
		int diff = Math.abs(score1 - score2);
		min = Math.min(min, diff);
	}


}
