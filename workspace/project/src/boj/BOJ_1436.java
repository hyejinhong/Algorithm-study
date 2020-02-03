package boj;

import java.util.*;
public class BOJ_1436 {

	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		int index = 1;
		int num = 666;
		
		while(index != n) {
			num++;
			
			// 666이 포함되는지 확인
			int temp = num;
			int numOfSix = 0;
			
			while(temp > 0) {
				if(temp%10 == 6) {
					numOfSix++;
				}
				else if(numOfSix < 3){
					numOfSix = 0;
				}
				temp /= 10;
			}
			
			if(numOfSix >= 3) {
				index++;
			}
		}
		
		System.out.println(num);
	}

}
