package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] originalScores = new double[n];
		double maxScore = 0;
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			originalScores[i] = Double.parseDouble(stk.nextToken());
			maxScore = Math.max(maxScore, originalScores[i]);
		}
		
		double[] newScores = new double[n];
		double sum = 0;
		for (int i=0; i<n; i++) {
			double newScore = originalScores[i] / maxScore * 100;
			newScores[i] = newScore;
			sum += newScore;
		}
		
		double result = sum / n;
		System.out.println(result);
	}

}
