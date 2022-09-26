package leetcode;

public class LeetCode_1662 {

	public static void main(String[] args) {
		String[] word1 = { "ab", "c" };
		String[] word2 = { "a", "bc" };
		
		System.out.println(arrayStringAreEqual(word1, word2));
	}

	public static boolean arrayStringAreEqual(String[] word1, String[] word2) {
		StringBuilder concat1 = new StringBuilder();
		StringBuilder concat2 = new StringBuilder();
		
		for(int i=0; i<word1.length; i++) {
			concat1.append(word1[i]);
		}
		for(int i=0; i<word2.length; i++) {
			concat2.append(word2[i]);
		}
		
		return concat1.toString().equals(concat2.toString());
	}
}
