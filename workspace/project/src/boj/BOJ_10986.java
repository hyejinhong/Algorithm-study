package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		long[] num = new long[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());

		long count = 0;

		long[] sum = new long[n];
		long[] numberOfMod = new long[m]; // 나머지의 범위는 0 ~ m-1

		for (int i = 0; i < n; i++) {
			num[i] = Long.parseLong(stk.nextToken());

			if (i == 0) {
				sum[0] = num[0] % m;
			} else {
				sum[i] = (num[i] + sum[i - 1]) % m;
			}

			// sum[i] == 0 이면, (0, i) 구간 합이 m의 배수라는 의미
			if (sum[i] == 0)
				count++;

			// sum[j]%m == sum[i-1]%m 인 경우
			// 왜냐면? sum[i~j] = sum[j] - sum [i-1];
			// ex) 3으로 나누어 나머지가 1인 두 수 7, 4를 생각해보자
			// 7 - 4 = 0, 같은 나머지를 같는 두수의 차는 나누어떨어지게 됨
			numberOfMod[(int) sum[i]]++;
		}

		// 각 각 나머지의 경우에서 2개씩 뽑을 수 있는 경우의 수를 계산한다
		for (int i = 0; i < m; i++) {
			if (numberOfMod[i] > 1)
				count += (numberOfMod[i] * (numberOfMod[i] - 1) / 2);
		}
		System.out.println(count);
	}

}
