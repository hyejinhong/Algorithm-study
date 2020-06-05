package programmers;

public class MaxValueAndMinValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {
			"1 2 3 4",
			"-1 -2 -3 -4",
			"-1 -1"
		};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(solution(s[i]));
		}
	}
	
    public static String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            int number = Integer.parseInt(arr[i]);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        String answer = min + " " + max;
        return answer;
    }

}
