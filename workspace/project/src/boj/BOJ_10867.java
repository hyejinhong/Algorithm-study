package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10867 {

	static int n;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
