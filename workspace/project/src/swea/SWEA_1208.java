package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1208 {
	
	static class Box implements Comparable<Box> {
		int index;
		int height;
		
		Box(int index, int height) {
			this.index = index;
			this.height = height;
		}

		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			return o.height - this.height;
		}
	}
	
	static int result = 0;
	static LinkedList<Box> h = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 10;
	
		for(int test=1; test<=c; test++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			for(int i=0; i<100; i++) {
				h.add(new Box(i, Integer.parseInt(stk.nextToken())));
			}
			
			dump(count);
			System.out.println("#" + test + " " + result);
			h.clear();
		}
	}
	
	// count번 dump할 수 있다.
	public static void dump(int count) {
		Collections.sort(h);
		
		Box highest = h.peek();
		Box lowest = h.peekLast();
		int ret = highest.height - lowest.height;
		
		// 기저: 평탄화 완료 or dump 횟수 끝
		if(ret <= 1 || count == 0) {
			result = ret;
			return;
		}
		
		// dump
		highest.height--;
		lowest.height++;
		
		// next
		dump(count-1);
	}

}
