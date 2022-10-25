package leetcode;

public class LeetCode_795 {

	public static void main(String[] args) {
//		int[] nums = { 2, 9, 2, 5, 6 };
//		int left = 2;
//		int right = 8;

//		int[] nums = { 2, 1, 4, 3 };
//		int left = 2;
//		int right = 3;
		
		int[] nums = { 73,55,36,5,55,14,9,7,72,52};
		int left = 32;
		int right = 69;		// 22
		System.out.println(numSubarrayBoundedMax2(nums, left, right));
	}
	
	// 시간 초과
	public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int lPointer = 0;
        int rPointer = 0;
        int count = 0;
        
        while (lPointer < nums.length) {
            if (rPointer >= nums.length)
                lPointer++;
            if (lPointer >= nums.length)
                break;
            
            int lNum = nums[lPointer];
            rPointer = lPointer;
            int max = lNum;

            
            // 어떻게 해도 안되므로 갱신
            if (lNum > right) {
                lPointer++;
            }
            else {
                while (rPointer < nums.length) {
                    int rNum = nums[rPointer];             
                    
                    max = Math.max(max, rNum);
                    
                    if (max > right) {
                        lPointer++;
                        rPointer = lPointer;
                        break;
                    }
                    else if (max < left) {
                        rPointer++;
                    }
                    else {
                        count++;
                        rPointer++;
                    }
                }
            }
        }   
        return count;
	}
	
	public static int numSubarrayBoundedMax2(int[] nums, int left, int right) {
		int sum = 0;
		int plus = 0;
		int minus = 0;
		
		for(int i=0; i<nums.length; i++) {
			int num = nums[i];
			
			if (num < left) {
				sum -= (++minus);
				sum += (++plus);
			}
			else if (num >= left && num <= right) {
				sum += (++plus);
				minus = 0;
			}
			else if (num > right) {
				plus = 0;
				minus = 0;
			}
		}
		
		return sum;
	}

}
