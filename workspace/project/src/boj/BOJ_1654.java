package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

	static int k, n;
	static int[] arr = new int[10000];
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		k = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		long max = 0;
		for(int i=0; i<k; i++) {
			stk = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(stk.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		long min = 1;
		long mid = 1;

		while(max >= min) {
			mid = (max + min) / 2;
			long count = 0;
			
			// �� ������ �ڸ� ���� ���� �� ��
			for(int i=0; i<k; i++) {
				count += arr[i]/mid;
			}
			// ���ų� ���� -> ������ ���������� �߸� ������ ���̰� �� �� ������ ������ �� �����Ƿ�
			// �� �� ��� �߶󺾴ϴ�.
			if(count >= n) {
				min = mid + 1;
			}
			// ���ڶ�
			else if(count < n) {
				max = mid - 1;
			}
		}
		
		System.out.println(max);
	}

}
