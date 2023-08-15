package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int S = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);

		String dna = br.readLine();
		String[] rules = br.readLine().split(" ");
		int ruleA = Integer.parseInt(rules[0]);
		int ruleC = Integer.parseInt(rules[1]);
		int ruleG = Integer.parseInt(rules[2]);
		int ruleT = Integer.parseInt(rules[3]);

		int start = 0;
		int end = P - 1;
		int result = 0;

		// 초기값
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);

		String subStr = dna.substring(start, end + 1);
		for (char c : subStr.toCharArray()) {
			map.put(c, map.get(c) + 1);
		}

		if (map.get('A') >= ruleA && map.get('C') >= ruleC && map.get('G') >= ruleG && map.get('T') >= ruleT) {
			result++;
		}

		start++;
		end++;

		// 슬라이딩
		while (end < S) {
			// 다시 계산
			// 버린 글자
			char left = dna.charAt(start - 1);
			map.put(left, map.get(left) - 1);

			// 추가된 글자
			char right = dna.charAt(end);
			map.put(right, map.get(right) + 1);

			// 조건 만족하면
			if (map.get('A') >= ruleA && map.get('C') >= ruleC && map.get('G') >= ruleG && map.get('T') >= ruleT) {
				result++;
			}

			// 민다
			start++;
			end++;
		}

		System.out.println(result);
	}

}
