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
		// 기저: 판자가 하나밖에 없는 경우
		if(left == right) {
			return heights[left];
		}
		
		// [left, mid] / [mid+1, right] 두 구간으로 분할
		int mid = (left + right) / 2;
		int result = Math.max(solve(heights, left, mid), solve(heights, mid+1, right));
		
		// 왼,오에 걸치는 부분 중 가장 큰 것 찾기
		int lo = mid;
		int hi = mid + 1;
		
		// [lo, hi] 2개에서의 넓이에서 시작
		int height = Math.min(heights[lo], heights[hi]);
		result = Math.max(result, height * 2);
		
		while(left < lo || hi < right) {
			// 왼/오 중 높이가 높은 쪽으로 확장
			
			// 오른쪽으로 확장 (왼쪽 끝까지 왔거나, 오른쪽 높이가 더 높은 경우)
			if(hi < right && (lo == left || heights[lo-1] < heights[hi+1])) {
				hi++;
				height = Math.min(height, heights[hi]);
			}
			// 왼쪽으로 확장
			else {
				lo--;
				height = Math.min(height, heights[lo]);
			}
			result = Math.max(result, height * (hi - lo + 1));
		}
		
		return result;
	}

}
