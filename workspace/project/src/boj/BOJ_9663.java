package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {

	static int n;
	static int count = 0;
	static int[] position; // 배열 인덱스: 행, 값: 열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		position = new int[n];
		
		dfs(0);
		
		System.out.println(count);
	}

	public static void dfs(int row) {
		// 기저: 모든 행에 퀸이 존재
		if (row == n) {
			count++;
			return;
		}

		// 모든 열에다가 놓아본다..
		for (int i = 0; i < n; i++) {
			position[row] = i;

			// 놓을 수 있나?
			if (putable(row, i)) {
				// 다음행 진행
				dfs(row + 1);
			}
		}
	}

	// col열에 말을 놓을 수 있는지
	public static boolean putable(int row, int col) {
		for (int i = 0; i < row; i++) {
			// 어떤 row에 있는 퀸이 col행을 이미 점유중
			if (position[i] == col) {
				return false;
			}
			// 대각선
			if (Math.abs(row - i) == Math.abs(position[row] - position[i])) {
				return false;
			}
		}

		return true;
	}
}
