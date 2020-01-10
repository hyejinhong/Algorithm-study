package algospot;

import java.util.*;

public class Fence {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			int n = scan.nextInt();
			int[] heights = new int[n];
			
			for(int i=0; i<n; i++) {
				heights[i] = scan.nextInt();
			}
			System.out.println(solve(heights, 0, n-1));
		}
	}
	
	public static int solve(int[] heights, int left, int right) {
		// ����: ���ڰ� �ϳ��ۿ� ���� ���
		if(left == right) {
			return heights[left];
		}
		
		// [left, mid] / [mid+1, right] �� �������� ����
		int mid = (left + right) / 2;
		int result = Math.max(solve(heights, left, mid), solve(heights, mid+1, right));
		
		// ��,���� ��ġ�� �κ� �� ���� ū �� ã��
		int lo = mid;
		int hi = mid + 1;
		
		// [lo, hi] 2�������� ���̿��� ����
		int height = Math.min(heights[lo], heights[hi]);
		result = Math.max(result, height * 2);
		
		while(left < lo || hi < right) {
			// ��/�� �� ���̰� ���� ������ Ȯ��
			
			// ���������� Ȯ�� (���� ������ �԰ų�, ������ ���̰� �� ���� ���)
			if(hi < right && (lo == left || heights[lo-1] < heights[hi+1])) {
				hi++;
				height = Math.min(height, heights[hi]);
			}
			// �������� Ȯ��
			else {
				lo--;
				height = Math.min(height, heights[lo]);
			}
			result = Math.max(result, height * (hi - lo + 1));
		}
		
		return result;
	}

}
