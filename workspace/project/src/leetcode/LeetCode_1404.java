package leetcode;

import java.math.BigInteger;

public class LeetCode_1404 {
	public static void main(String[] args) {
//		String s = "1101"; // 6
//		String s = "10"; // 1
//		String s = "1";
//		String s = "1111011110000011100000110001011011110010111001010111110001"; // 85
		String s = "1111110011101010110011100100101110010100101110111010111110110010"; //

		System.out.println(numSteps(s));
	}

	public static int numSteps(String s) {
		int count = 0;
		BigInteger number = new BigInteger(s, 2);
		
		while (!number.equals(BigInteger.ONE)) {
			count++;

			// 짝수: 나누기 2
			if (number.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
				number = number.shiftRight(1);
			}
			// 홀수: 더하기 1
			else {
				number = number.add(BigInteger.ONE);
			}
			
		}
		return count;
	}
}
