package programmers;

public class YinYangPlus {

	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
		
		System.out.println(solution(absolutes, signs));
	}
	
    public static int solution(int[] absolutes, boolean[] signs) {
    	
    	int sum = 0;
    	for(int i=0; i<absolutes.length; i++) {
    		int number = absolutes[i];
    		boolean sign = signs[i];
    		
    		if(sign)
    			sum += number;
    		else
    			sum -= number;
    	}
    	
        return sum;
    }
}
