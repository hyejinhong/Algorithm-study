package algospot;

import java.util.Arrays;

public class SortTest {
	static int[] arr = {90, 4, 8, 91, 9, 23, 12, 93, 7, 18};
	static int[] sorted = new int[arr.length];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		mergeSort(arr, 0, arr.length-1);
		int result = 0 | 1;
		System.out.println(result);
	}
	
	public static void merge(int[] arr, int m, int mid, int n) {
		int i = m;
		int j = mid + 1;
		int k = m;
		
		while(i <= mid && j <= n) {
			if(arr[i] <= arr[j]) {
				sorted[k] = arr[i];
				i++;
			}
			else {
				sorted[k] = arr[j];
				j++;
			}
		}
		
		if(i > mid) {
			for(int t=j; t<=n; t++, k++) {
				sorted[k] = arr[t];
			}
		}
		else {
			for(int t=i; t<=mid; t++, k++) {
				sorted[k] = arr[t];
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int m, int n) {
		if(m<n) {
			int mid = (m + n) / 2;
			mergeSort(arr, m, mid); // 앞부분
			mergeSort(arr, mid+1, n); // 뒷부분
			merge(arr, m, mid, n); // 정렬과 병합
		}
	}
	

}
