package algospot;

import java.util.*;
public class Fence_2 {
	
	static int n;
	static int[] heights;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			heights = new int[n];
			
			for(int i=0; i<n; i++) {
				heights[i] = scan.nextInt();
			}
			System.out.println(solve(0, n-1));
		}
	}
	
	public static int solve(int left, int right) {
		// ����: ���� �Ѱ�
		if(left == right) {
			return heights[left];
		}
		
		int mid = (left + right) / 2;
		
		// ����, ������
		int result = Math.max(solve(left, mid), solve(mid+1, right));

		// �����ִ°�?
		int l = mid;
		int r = mid+1;
		int height = Math.min(heights[l], heights[r]);
		
		// [l, r] ���̿��� ����
		int temp = 2 * height;
		result = Math.max(result, temp);
		
		while(left < l || right > r) {
			// ���������� Ȯ��
			if(r < right && (l == left || heights[l-1] < heights[r+1])) {
				r++;
				height = Math.min(height, heights[r]);
			}
			// �������� Ȯ��
			else {
				l--;
				height = Math.min(height, heights[l]);
			}
			result = Math.max(result, (r-l+1)*height);
		}
		return result;
	}

}