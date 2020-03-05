package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		// TODO Auto-generated method stub
		int ret = this.end - o.end;
		if(this.end == o.end) {
			ret = this.start - o.start;
		}
		return ret;
	}
}

public class BOJ_1931 {

	static int n;
	static Meeting[] meetings;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		meetings = new Meeting[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			meetings[i] = new Meeting(start, end);
		}
		
		System.out.println(schedule());
	}
	
	// 최대 사용할 수 있느 회의 수 반환
	public static int schedule() {
		int count = 1;
		Arrays.sort(meetings);
		
		int end = meetings[0].end;
		for(int i=1; i<meetings.length; i++) {
			// 겹치지 않는 스케줄이면
			if(meetings[i].start >= end) {
				count++;
				end = meetings[i].end;
			}
		}
		return count;
	}

}
