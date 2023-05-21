package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {

	static int n;
	static char[][] map;
	static boolean[][] visited;

	static ArrayList<Integer> teacherY;
	static ArrayList<Integer> teacherX;

	static String answer = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		teacherY = new ArrayList<>();
		teacherX = new ArrayList<>();

		map = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int j = 0;
			while (stk.hasMoreTokens()) {
				char ch = stk.nextToken().charAt(0);

				map[i][j] = ch;
				if (ch == 'T') {
					teacherY.add(i);
					teacherX.add(j);
				}

				j++;
			}
		}

		dfs(0, 0, 0);
		System.out.println(answer.equals("") ? "NO" : "YES");
	}

	// 현재까지 count개의 장애물을 설치함
	private static void dfs(int y, int x, int count) {
		// 기저 : 3개 다 설치함
		if (count == 3) {
			if (isPossible()) {
				answer = "YES";
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;

				if (map[i][j] != 'X')
					continue;

				// 설치해본다
				visited[i][j] = true;
				map[i][j] = 'O';
				dfs(i, j, count + 1);
				// 철거한다
				visited[i][j] = false;
				map[i][j] = 'X';
			}
		}
	}

	// 모든 학생이 피할 수 있는지 여부 반환
	private static boolean isPossible() {
		for (int i = 0; i < teacherY.size(); i++) {
			int y = teacherY.get(i);
			int x = teacherX.get(i);

			// 상
			for (int j = y - 1; j >= 0; j--) {
				if (map[j][x] == 'O')
					break;

				if (map[j][x] == 'S')
					return false;
			}

			// 하
			for (int j = y + 1; j < n; j++) {
				if (map[j][x] == 'O')
					break;

				if (map[j][x] == 'S')
					return false;
			}

			// 좌
			for (int j = x - 1; j >= 0; j--) {
				if (map[y][j] == 'O')
					break;

				if (map[y][j] == 'S')
					return false;
			}

			// 우
			for (int j = x + 1; j < n; j++) {
				if (map[y][j] == 'O')
					break;

				if (map[y][j] == 'S')
					return false;
			}
		}

		return true;
	}

	private static void getO() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
				if (map[i][j] == 'O') {
					str.append("[" + i + ", " + j + "]");
				}
			}
			System.out.println();
		}
		System.out.println();
		if (str.toString().equals("[0, 3][1, 1][2, 2]")) {
			System.out.println(str.toString());
		}
	}
}
