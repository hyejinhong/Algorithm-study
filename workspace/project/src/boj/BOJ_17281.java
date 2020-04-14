package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281 {

	static int n;
	static int[][] arr = new int[50][10]; // [�̴�][����]
	static boolean[] check = new boolean[10];
	static int[] player = new int[10]; // player[4] = 1; 4�� ������ 1��°
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		player[4] = 1;
		check[1] = true;
		
		setPlayer(1);
		System.out.println(max);
	}

	// ���� ��ġ
	public static void setPlayer(int index) {
		// 4�� �����̸� ��ŵ
		if(index == 4) {
			setPlayer(index+1);
			return;
		}
		
		// ����: ��ġ �Ϸ�
		if(index == 10) {
			int score = play();
			max = Math.max(max, score);
			return;
		}
		
		for(int i=2; i<=9; i++) {
			if(!check[i]) {
				player[index] = i;
				check[i] = true;
				
				setPlayer(index+1);
				
				check[i] = false;
			}
		}
	}
	
	public static int play() {
		int score = 0;
		int out;
		
		boolean[] roo = new boolean[4]; // 0: Ȩ, 123: ��
		int playerNum = 1;
		
		// �̴� ����ŭ ����
		for(int i=0; i<n; i++) {
			out = 0;
			Arrays.fill(roo, false);
			
			while(out < 3) {
				int state = arr[i][player[playerNum++]];
				
				// ���� ����
				if(playerNum == 10) {
					playerNum = 1;
				}
				
				switch(state) {
				case 0: // �ƿ�
					out++;
					break;
				case 1: // ��Ÿ
					// 3�� -> Ȩ
					if(roo[3]) {
						score++;
						roo[3] = false;
					}
					// 1, 2�� -> 2, 3��
					for(int r=2; r>=1; r--) {
						if(roo[r]) {
							roo[r] = false;
							roo[r+1] = true;			
						}
					}
					// X -> 1��
					roo[1] = true;
					break;
				case 2: // 2��Ÿ
					// 3�� -> Ȩ
					if(roo[3]) {
						score++;
						roo[3] = false;
					}
					// 2�� -> Ȩ
					if(roo[2]) {
						score++;
						roo[2] = false;
					}
					// 1�� -> 3��
					if(roo[1]) {
						roo[3] = true;
						roo[1] = false;
					}
					// X -> 2��
					roo[2] = true;
					break;
				case 3: // 3��Ÿ
					// 1��, 2��, 3�� -> Ȩ
					for(int r=1; r<=3; r++) {
						if(roo[r]) {
							score++;
							roo[r] = false;			
						}
					}
					// X -> 3��
					roo[3] = true;
					break;
				case 4: // Ȩ��
					// 1��, 2��, 3�� -> Ȩ
					for(int r=1; r<=3; r++) {
						if(roo[r]) {
							score++;
							roo[r] = false;
						}
					}
					// X -> Ȩ
					score++;
					break;
				}
			}
		}
		return score;
	}
}
