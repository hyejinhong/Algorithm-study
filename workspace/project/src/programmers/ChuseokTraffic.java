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
		System.out.println(solution(lines)); // ��:2
	}
	
	public static int solution(String[] lines) throws Exception {	
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		
		int[] mark = new int[lines.length];
		int max = 0;
		
		long end = 0;
		
		for(int i=0; i<lines.length; i++) {
			String[] temp = lines[i].split(" ");
	
			Date nowEnd = format.parse(temp[1]); // ó�� ���� �ð�
			double sec = Double.parseDouble(temp[2].substring(0, temp[2].length()-1)); // ó�� �ð�
			
			end = nowEnd.getTime(); // ���� ������ �۾��� ������ �ð�
			System.out.println(format.format(new Date(end)));
			
			for(int j=i; j<lines.length; j++) {
				temp = lines[j].split(" ");
				nowEnd = format.parse(temp[1]);
				sec = Double.parseDouble(temp[2].substring(0, temp[2].length()-1)); // ó�� �ð�
				
				long start = (long) (nowEnd.getTime() - sec*1000 + 1); // ���Ŀ� ������ �۾��� �����ϴ� �ð�
				start -= 1000; // �� ���۽ð����� 1�ʸ� �� �ð�
				System.out.println(format.format(new Date(start)));
				
				// ���۽ð����� 1�ʸ� �A �ð��� �� �� �۾� ������ �ͺ��� �ڿ� ������ ��ġ�� ������
				if(start - end <= 0) {
					mark[i]++;
					max = Math.max(max, mark[i]);
				}
			}
		}
		
		return max;
	}
}
