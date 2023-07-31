package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_2 {

	static int test;
	static int m, n, k;
	static int[][] map;
	static int count;

	// 상하좌우
	final static int[] dy = { -1, 1, 0, 0 };
	final static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			init(br);
						
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					// 배추가 있고 AND 방문한 적 없음 -> 거기로 이동
					if (map[y][x] == 1) {
						dfs(y, x);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	private static void dfs(int y, int x) {
		map[y][x] = 3;

		// 이동할 수 있음
		for (int i = 0; i < dy.length; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (!rangeAvaialable(ny, nx))
				continue;
			
			if (map[ny][nx] == 1)
				dfs(ny, nx);
		}
	}

	private static boolean rangeAvaialable(int y, int x) {
		if (y < 0 || y >= n)
			return false;
		if (x < 0 || x >= m)
			return false;
		return true;
	}

	private static void init(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] splited = line.split(" ");

		count = 0;
		m = Integer.parseInt(splited[0]);
		n = Integer.parseInt(splited[1]);
		k = Integer.parseInt(splited[2]);
		map = new int[n][m];

		for (int i = 0; i < k; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			map[y][x] = 1;
		}
	}
}
