package leetcode;

import java.util.Arrays;

public class LeetCode_2037 {

	public static void main(String[] args) {
//		int[] seats = {3,1,5};
//		int[] students = {2,7,4};
		
		int[] seats = {4, 1, 5, 9};
		int[] students = {1, 3, 2, 6};

		System.out.println(minMovesToSeat(seats, students));
	}

	public static int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);
		
		int result = 0;
		for (int i=0; i<seats.length; i++) {
			result += Math.abs(seats[i] - students[i]);
		}
		
		return result;
	}
}
