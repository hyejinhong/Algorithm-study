package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_739 {

	public static void main(String[] args) {
		int[] temperatures = { 73,74,75,71,69,72,76,73 };
		System.out.println(Arrays.toString(dailyTenperatures(temperatures)));
	}

	public static int[] dailyTenperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<temperatures.length; i++) {
        	while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        		int index = stack.pop();
        		result[index] = i - index;
        	}
        	stack.push(i);
        }
        
        return result;
	}
}
