package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17136 {
	
	static int[][] map = new int[10][10];
	static int[] paper = new int[6];
	
	static int min = 9999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// ������ 5�徿
		for(int i=1; i<=5; i++) {
			paper[i] = 5;
		}
		
		search(0, 0);
		System.out.println(min == 9999 ? -1 : min);
	}
	
	// sum: ���ݱ��� �� ���� ����
	public static void search(int index, int sum) {
		// ���� : ���� ������ �Խ��ϴ�
		if(index == 100) {
			min = Math.min(min, sum);
			return;
		}
		
		// ���� ����� ������ ���� ���� ������ �׳� ������
		if(sum > min) {
			return;
		}

		// Ž�� ����
		int r = index / 10;
		int c = index % 10;
		
		if(map[r][c] == 1) {
			// ���η� 1�� �󸶳� ���� �˾Ƴ�
			int width = 0;
			int nx = c;
			while(nx < 10 && map[r][nx] == 1) {
				width++;
				nx++;
			}
			
			// 1~width ���� �簢�� ���� �� �ֳ� �ϳ��� �˻�
			// ��, width�� 5�� ������ 5��..
			if(width > 5) {
				width = 5;
			}
			for(int k=width; k>=1; k--) {
				// �簢�� ���� �� ������
				if(isValidSquare(r, c, k)) {
					// ������ ���̰�
					// ��, width �����̰� �������� ������ skip
					if(paper[k] <= 0) {
						continue;
					}
					set(r, c, k, 2);
					paper[k]--;
					// ���� Ž��
					search(index+1, sum+1);
					// ������ ��
					set(r, c, k, 1);
					paper[k]++;
				}
			}	
		}
		else {
			search(index+1, sum);
		}
	}
	
	// (y, x)���� �����ϴ� �� ���� width�� ���簢�� �����̸� ���̰ų� ��
	// Ÿ�� 2: ����, 1: ��
	public static void set(int y, int x, int width, int type) {
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				map[i][j] = type;
			}
		}
	}
	
	// (y, x)���� �����ϴ� �� ���� width�� ���簢���� �����ϴ���..
	public static boolean isValidSquare(int y, int x, int width) {
		if(y+width > 10 || x+width > 10) {
			return false;
		}
		
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
}
