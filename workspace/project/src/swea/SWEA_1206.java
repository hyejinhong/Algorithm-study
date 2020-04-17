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
			// 1. ������ �ǹ��� ������ ������ �ȵ�
			if(h[i] < h[i+1]) {
				continue;
			}
			
			// �� �� 2ĭ ������ �ǹ��� ���� �� ���� �� �˾Ƴ�
			int nearMax = 0;
			for(int j=-2; j<=2; j++) {
				// �ڱ� �ڽŰ��� ����������
				if(j == 0) {
					continue;
				}
				nearMax = Math.max(nearMax, h[i+j]);
			}
			
			// �� �ǹ����� ���� ������ �������� Ȯ���� ����
			if(h[i] > nearMax) {
				count += (h[i]- nearMax);
			}
		}
		
		return count;
	}

}
