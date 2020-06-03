package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	static int n, c;
	static int[] houses;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		houses = new int[n];
		
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(houses);
		System.out.println(binarySearch());
	}
	
	public static int binarySearch() {
		int left = 1; // �ּҰŸ�
		int right = houses[houses.length-1];
		int mid = 0;
				
		int max = Integer.MIN_VALUE;
		
		while(left <= right) {
			mid = (left + right) / 2;
			
			// �����Ⱑ C�� �̻� ��ġ�� -> ���� ���� �ִ�
			if(isValid(mid)) {
				max = Math.max(max, mid);
				left = mid+1;
			}
			// C������ ���� ��ġ�� -> �� �Ÿ��� ������ ��.
			else {
				right = mid-1;
			}
		}
		return max;
	}
	
	public static boolean isValid(int mid) {
		int prev = houses[0];
		int count = 1; // ������ ����
		
		for(int i=1; i<houses.length; i++) {
			int house = houses[i];
			
			// ���� ������ ��ġ ���� ���� ���� �Ÿ� ���̰� mid �̻��ΰ�?
			if(house-prev >= mid) {
				count++; // ������ ��ġ
				prev = house;
			}
		}
		
		// �����Ⱑ c������ ���� ��ġ��
		if(count >= c) {
			return true;
		}
		// c������ ���� ��ġ�Ǿ���
		else {
			return false;
		}
	}
}
