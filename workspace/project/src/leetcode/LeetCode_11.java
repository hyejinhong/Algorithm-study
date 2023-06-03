package leetcode;

public class LeetCode_11 {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		LeetCode_11 instance = new LeetCode_11();
		System.out.println(instance.maxArea(height));
	}

	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxWater = 0;

		while (left <= right) {
			// 계산해보기
			int water = calculate(right - left, Math.min(height[left], height[right]));
			maxWater = Math.max(maxWater, water);
			
			// 왼/오 어디를 옮겨볼지 결정
			// 더 짧은 쪽을 포기하고 옮김
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxWater;
	}

	private int calculate(int width, int height) {
		int water = width * height;
		return water;
	}
}
