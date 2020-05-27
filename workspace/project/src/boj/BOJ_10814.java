package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_10814 {

	static class Member implements Comparable<Member> {
		String name;
		int age;
		int index; // 가입한 순서
		
		Member(String name, int age, int index) {
			this.name = name;
			this.age = age;
			this.index = index;
		}
		
		@Override
		public int compareTo(Member o) {
			// 나이순
			int result = this.age - o.age;
			if(result == 0) {
				return this.index - o.index;
			}
			else {
				return result;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Member[] members = new Member[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(stk.nextToken());
			String name = stk.nextToken();
			
			members[i] = new Member(name, age, i);
		}
		
		Arrays.sort(members);
		
		for(int i=0; i<members.length; i++) {
			System.out.println(members[i].age + " " + members[i].name);
		}
		
	}

}
