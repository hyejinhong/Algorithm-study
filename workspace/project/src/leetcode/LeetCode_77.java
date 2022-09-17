package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77 {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;

		System.out.println(combine(n, k));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		boolean[] check = new boolean[n + 1];

		dfs(ret, new ArrayList<>(), n, k, 1, 1);

		return ret;
	}

	public static void dfs(List<List<Integer>> ret, List<Integer> inner, int n, int k, int depth, int cur) {
		// 기저 : k개 다 찼음
		if (depth > k) {
			ret.add(new ArrayList<Integer>(inner));
			return;
		}

		// cur보다 큰 숫자들 백트래킹
		for (int i = cur; i <= n; i++) {
			inner.add(i);
			dfs(ret, inner, n, k, depth + 1, i + 1);
			inner.remove(inner.size() - 1);
		}

	}
}
