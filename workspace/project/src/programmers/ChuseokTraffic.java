package programmers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChuseokTraffic {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = {
				"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
		};
//		String[] lines = {
//				"2016-09-15 01:00:04.001 2.0s",
//				"2016-09-15 01:00:07.000 2s"
//		};


		for(int i=0; i<lines.length; i++) {
			System.out.println(lines[i]);
		}
		System.out.println(solution(lines)); // 답:2
	}
	
	public static int solution(String[] lines) throws Exception {	
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		
		int[] mark = new int[lines.length];
		int max = 0;
		
		long end = 0;
		
		for(int i=0; i<lines.length; i++) {
			String[] temp = lines[i].split(" ");
	
			Date nowEnd = format.parse(temp[1]); // 처리 끝난 시간
			double sec = Double.parseDouble(temp[2].substring(0, temp[2].length()-1)); // 처리 시간
			
			end = nowEnd.getTime(); // 먼저 시작한 작업이 끝나는 시간
			System.out.println(format.format(new Date(end)));
			
			for(int j=i; j<lines.length; j++) {
				temp = lines[j].split(" ");
				nowEnd = format.parse(temp[1]);
				sec = Double.parseDouble(temp[2].substring(0, temp[2].length()-1)); // 처리 시간
				
				long start = (long) (nowEnd.getTime() - sec*1000 + 1); // 이후에 시작한 작업이 시작하는 시간
				start -= 1000; // 이 시작시간에서 1초를 뺀 시간
				System.out.println(format.format(new Date(start)));
				
				// 시작시간에서 1초를 뺸 시간이 이 전 작업 끝나는 것보다 뒤에 있으면 겹치는 구간임
				if(start - end <= 0) {
					mark[i]++;
					max = Math.max(max, mark[i]);
				}
			}
		}
		
		return max;
	}
}
