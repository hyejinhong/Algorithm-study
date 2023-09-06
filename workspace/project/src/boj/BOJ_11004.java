package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004 {

	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		arr = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int i = 0;
		while (stk.hasMoreElements()) {
			arr[i++] = Integer.parseInt(stk.nextToken());
		}

		quickSort(0, N - 1, K - 1);

		System.out.println(arr[K - 1]);
	}

	private static void quickSort(int start, int end, int K) {
		// 정렬할 것이 1개 이하
		if (start >= end)
			return;

		int pivot = partition(start, end);
		
		// 더이상 구할 필요 없음
		if (pivot == K)
			return;
		
		// 왼쪽만 정렬 수행
		else if (K < pivot)
			quickSort(start, pivot-1, K);
		// 오른쪽만 정렬 수행
		else
			quickSort(pivot + 1, end, K);
	}

	private static int partition(int start, int end) {
		if (start + 1 == end) {
			if (arr[start] > arr[end])
				swap(start, end);
			return end;
		}

		int mid = (start + end) / 2;
		swap(start, mid);

		int pivot = arr[start];
		int i = start + 1;
		int j = end;

		while (i <= j) {
			while (j >= start + 1 && pivot < arr[j])
				j--;

			while (i <= end && pivot > arr[i])
				i++;

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}

		arr[start] = arr[j];
		arr[j] = pivot;
		return j;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
