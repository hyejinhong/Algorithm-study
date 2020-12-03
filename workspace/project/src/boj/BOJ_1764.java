package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1764 {

	static int n, m;
	
	static HashSet<String> set1 = new HashSet<>();
	static ArrayList<String> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		// input
		for(int i=0; i<n; i++) {
			set1.add(br.readLine());
		}
		
		// set1에 있는 값만 저장해도 됨
		for(int i=0; i<m; i++) {
			String name = br.readLine();
			if(set1.contains(name)) {
				result.add(name);
			}
		}
		
		// print
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
