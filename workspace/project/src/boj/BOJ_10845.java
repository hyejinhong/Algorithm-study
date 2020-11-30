package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_10845 {

	static int n;
	static LinkedList<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			String[] o = str.split(" ");
			
			switch(o[0]) {
			case "push":
				q.offer(Integer.parseInt(o[1]));
				break;
			case "pop":
				System.out.println(q.isEmpty() ? -1 : q.poll());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println(q.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(q.isEmpty() ? -1 : q.peek());
				break;
			case "back":
				System.out.println(q.isEmpty() ? -1 : q.getLast());
			}
		}
	}

}
