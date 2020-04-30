package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_4408 {

	static class Student implements Comparable<Student> {
		int from; // 현재 방 번호
		int to; // 가야하는 방 번호
		int len; // 거리
		
		Student(int from, int to) {
			if(from > to) {
				this.from = to;
				this.to = from;
			}
			else {
				this.from = from;
				this.to = to;				
			}
			
			this.from = this.from%2 == 0 ? this.from : this.from + 1;
			this.to = this.to%2 == 0 ? this.to : this.to + 1;
			
			this.len = to/2 - from/2 + 1;
		}

		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			// 오름차순
			return this.from - o.from;
		}
	}
	
	static int n;
	static ArrayList<Student> students = new ArrayList<>();
	static boolean[] corridor = new boolean[201];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for(int test=1; test<=t; test++) {
			n = Integer.parseInt(br.readLine().trim());

			for(int i=0; i<n; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				
				students.add(new Student(from, to));
			}
			
			System.out.println("#" + test + " " + solve());
			students.clear();
		}
	}

	public static int solve() {
		// 가야할 거리가 짧은 사람부터 이동해야함, 소팅
//		getLength();
		Collections.sort(students);
		
		int count = 0;
		while(!students.isEmpty()) {
			Student s = students.get(0);
			
			// 복도 점거
			for(int i=s.from/2; i<=s.to/2; i++) {
				corridor[i] = true;
			}
			
			// 동시에 이동 가능한 사람은 동시에 ㄱㄱ
			// for문 size만큼 도니까 삭제할 것을 저장했다가 지우기..
			ArrayList<Student> beRemoved = new ArrayList<>();
			beRemoved.add(s);
			
			for(int i=1; i<students.size(); i++) {
				Student temp = students.get(i);
				// 동시에 됨!!
				if(isValid(temp)) {
					// 복도 점거
					for(int j=temp.from/2; j<=temp.to/2; j++) {
						corridor[j] = true;
					}
					beRemoved.add(temp);
				}
			}
			
			// 삭제
			for(int i=0; i<beRemoved.size(); i++) {
				Student r = beRemoved.get(i);
				students.remove(r);
			}
			

			Arrays.fill(corridor, false);
			count++;
		}
		
		return count;
	}
	
	public static boolean isValid(Student s) {
		for(int i=s.from/2; i<=s.to/2; i++) {
			// 가는 경로에 사용중인 복도가 있다
			if(corridor[i]) {
				return false;
			}
		}
		return true;
	}
}
