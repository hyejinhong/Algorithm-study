package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	static int n;
	static int m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			StringTokenizer stk = new StringTokenizer(line);

			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		// 합배열 만들기
		long[][] sums = new long[n + 1][n + 1];
		sums[1][1] = map[1][1];

		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				sums[x][y] = sums[x-1][y] + sums[x][y-1] - sums[x-1][y-1] + map[x][y];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String[] xys = br.readLine().split(" ");

			int x1 = Integer.parseInt(xys[0]);
			int y1 = Integer.parseInt(xys[1]);
			int x2 = Integer.parseInt(xys[2]);
			int y2 = Integer.parseInt(xys[3]);
			
			long result = sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1];
			sb.append(result);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}	
}
