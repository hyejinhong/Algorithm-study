package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelopment {

	static class Work {
		int prog;
		int speed;
		
		Work(int prog, int speed) {
			this.prog = prog;
			this.speed = speed;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int day = 0; 
		ArrayList<Work> list = new ArrayList<>();
		String str = "";
		
		// input
		for(int i=0; i<progresses.length; i++) {
			list.add(new Work(progresses[i], speeds[i]));
		}
		
		while(!list.isEmpty()) {
			day++;
			
			// 오늘 작업을 한다
			work(list);
			
			boolean flag = false;
			// 배포
			int count = 0; // 하루 배포 횟수

			while(!list.isEmpty() && list.get(0).prog >= 100) {
				list.remove(0);
				flag = true;
				count++;
			}
			
			if(flag) {
				str += count + "/";
			}
		}
		
		String[] temp = str.split("/");
		int[] answer = new int[temp.length];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = Integer.parseInt(temp[i]);
		}
		return answer;
	}
	
	public static void work(ArrayList<Work> list) {
		for(int i=0; i<list.size(); i++) {
			Work work = list.get(i);
			work.prog += work.speed;
		}
	}
}
