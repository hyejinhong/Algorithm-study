package boj;

import java.util.*;
public class BOJ_11047 {

	static int n;
	static int k;
	static int[] arr = new int[11];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		k = scan.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println(pick(k));
	}
	
	
	// k를 넘지 않는 가장 큰 것들을 계속 더한다..
	// money: 남은 돈, coin: 현재 쓴 동전 개수
	public static int pick(int money) {
		// 기저: 남은 돈이 가장 싼 동전보다 작을 때
		if(money < arr[0]) {
			return 0;
		}
		
		// money를 넘지 않는 가장 큰  동전 찾기
//		int index = n-1;
//		for(int i=1; i<n; i++) {
//			if(arr[i] > money) {
//				index = i-1;
//				break;
//			}
//			else if(arr[i] == money) {
//				index = i;
//				break;
//			}
//		}
//		
//		return 1 + pick(money-arr[index], coin+1);
		int ret = 0;
		int afterMoney = 0;
		
		for(int i=n-1; i>=0; i--) {
			if(money/arr[i] > 0) {
				afterMoney = money%arr[i];
				ret = money/arr[i];
				break;
			}
		}
		return ret + pick(afterMoney);
	}
}
