package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindPrimeNumber {

	static int[] card = new int[7];
	static boolean[] check = new boolean[7]; // 카드 썼는지 안썼는지
	static ArrayList<Integer> picked = new ArrayList<>();
	
	static HashMap<Integer, Boolean> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
		// 카드 만들기
		makeCards(numbers);
		
		// 카드 뽑아서 숫자 만들기
		int n = numbers.length();
		for(int i=1; i<=n; i++) {
			pick(n, i);
			picked.clear();
			Arrays.fill(check, false);
		}
		
		int answer = map.size();
		return answer;
	}
	
	public static void makeCards(String numbers) {
		for(int i=0; i<numbers.length(); i++) {
			card[i] = Integer.parseInt(numbers.substring(i, i+1));
		}
	}
	
	public static boolean isPrime(int number) {
		if(number == 1 || number == 0) {
			return false;
		}
		
		for(int i=2; i<number; i++) {
			if(number%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// limit장까지 카드 뽑음
	public static void pick(int n, int limit) {
		// 기저: 다 뽑음
		if(picked.size() == limit) {
			int number = getNumber();
			if(isPrime(number)) {
				map.put(number, true);
				return;
			}
			else {
				return;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				picked.add(card[i]);
				check[i] = true;
				
				pick(n, limit);
				
				picked.remove(picked.size()-1);
				check[i] = false;
			}
		}
	}
	
	public static int getNumber() {
		int ret = 0;
		
		String str = "";
		for(int i=0; i<picked.size(); i++) {
			str += picked.get(i);
		}
		
		ret = Integer.parseInt(str);
		return ret;
	}
}
