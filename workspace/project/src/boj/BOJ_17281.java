package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281 {

	static int n;
	static int[][] arr = new int[50][10]; // [이닝][선수]
	static boolean[] check = new boolean[10];
	static int[] player = new int[10]; // player[4] = 1; 4번 선수가 1번째
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

	// 선수 배치
	public static void setPlayer(int index) {
		// 4번 선수이면 스킵
		if(index == 4) {
			setPlayer(index+1);
			return;
		}
		
		// 기저: 배치 완료
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
		
		boolean[] roo = new boolean[4]; // 0: 홈, 123: 루
		int playerNum = 1;
		
		// 이닝 수만큼 진행
		for(int i=0; i<n; i++) {
			out = 0;
			Arrays.fill(roo, false);
			
			while(out < 3) {
				int state = arr[i][player[playerNum++]];
				
				// 다음 선수
				if(playerNum == 10) {
					playerNum = 1;
				}
				
				switch(state) {
				case 0: // 아웃
					out++;
					break;
				case 1: // 안타
					// 3루 -> 홈
					if(roo[3]) {
						score++;
						roo[3] = false;
					}
					// 1, 2루 -> 2, 3루
					for(int r=2; r>=1; r--) {
						if(roo[r]) {
							roo[r] = false;
							roo[r+1] = true;			
						}
					}
					// X -> 1루
					roo[1] = true;
					break;
				case 2: // 2루타
					// 3루 -> 홈
					if(roo[3]) {
						score++;
						roo[3] = false;
					}
					// 2루 -> 홈
					if(roo[2]) {
						score++;
						roo[2] = false;
					}
					// 1루 -> 3루
					if(roo[1]) {
						roo[3] = true;
						roo[1] = false;
					}
					// X -> 2루
					roo[2] = true;
					break;
				case 3: // 3루타
					// 1루, 2루, 3루 -> 홈
					for(int r=1; r<=3; r++) {
						if(roo[r]) {
							score++;
							roo[r] = false;			
						}
					}
					// X -> 3루
					roo[3] = true;
					break;
				case 4: // 홈런
					// 1루, 2루, 3루 -> 홈
					for(int r=1; r<=3; r++) {
						if(roo[r]) {
							score++;
							roo[r] = false;
						}
					}
					// X -> 홈
					score++;
					break;
				}
			}
		}
		return score;
	}
}
