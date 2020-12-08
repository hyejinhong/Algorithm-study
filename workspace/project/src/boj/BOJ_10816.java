package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816 {

	static int n, m;
	static HashMap<Integer, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if(hash.containsKey(num)) {
				int freq = hash.get(num);
				hash.put(num, ++freq);
			}
			else {
				hash.put(num, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(stk.nextToken());
			Integer value = hash.get(num);
			
			if(value == null) {
				sb.append(0 + " ");
			}
			else {
				sb.append(value + " ");
			}
		}
		System.out.println(sb.toString());
	}

}
