package boj;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class BOJ_1431 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] serials = new String[n];
		
		for(int i=0; i<n; i++) {
			serials[i] = br.readLine();
		}
		
		Arrays.sort(serials, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 길이
				int result = s1.length() - s2.length();
				
				// 길이가 같으면
				if(result == 0) {
					// 자리수의 합 비교..
					int sum1 = 0;
					int sum2 = 0;
					for(int i=0; i<s1.length(); i++) {
						char c1 = s1.charAt(i);
						char c2 = s2.charAt(i);
						
						if(c1 >= '0'  && c1 <= '9') {
							sum1 += (c1 - '0');
						}
						if(c2 >= '0'  && c2 <= '9') {
							sum2 += (c2 - '0');
						}
					}
					
					int sumResult = sum1 - sum2;
					
					// 자릿수 합마저 같다면, 사전순
					if(sumResult == 0) {
						return s1.compareTo(s2);
					}
					else {
						return sumResult;
					}
				}
				else {
					return result;
				}
			}
		});
		
		for(int i=0; i<serials.length; i++) {
			System.out.println(serials[i]);
		}
	}

}
