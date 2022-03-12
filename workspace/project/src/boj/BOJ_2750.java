package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2750 {
	
	static int n;
	static int[] array = new int[1000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		bubbleSort();
	}
	
	public static void bubbleSort() {
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				// 앞 원소가 더 크다면 swap
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(array[i]);
		}
	}
}
