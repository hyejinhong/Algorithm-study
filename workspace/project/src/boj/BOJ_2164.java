package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

	static int n;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// input
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		while(q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}

		System.out.println(q.poll());
		
	}

}
