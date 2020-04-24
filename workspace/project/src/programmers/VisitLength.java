package programmers;

import java.util.HashMap;

public class VisitLength {

	static class Point {
		int y;
		int x;
		
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+this.y+", "+this.x +")";
		}
	}
	
	static int[][] map = new int[11][11];
	static HashMap<String, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dirs = "ULURRDLLU";
//		String dirs = "LULLLLLLU";
		System.out.println(solution(dirs));
	}

	public static int solution(String dirs) {
		Point start = new Point(5, 5);
		// 객체를 미리 다 만들어놔
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				
			}
		}
		
		// dirs 실행
		for(int i=0; i<dirs.length(); i++) {
			char dir = dirs.charAt(i);
			
			// move
			Point end = move(start, dir);
			
			// 지나온 길 저장
			if(end != null) {
				String r1 = start.toString() + end.toString();
				String r2 = end.toString() + start.toString();
				
				hash.put(r1, 0);
				hash.put(r2, 0);
				start = new Point(end.y, end.x);
			}
		}
		
		int answer = hash.size() / 2;
		return answer;
	}
	
	public static Point move(Point start, char dir) {
		Point end = null;
		
		// 위
		if(dir == 'U') {
			end = new Point(start.y-1, start.x);
		}
		// 아래
		else if(dir == 'D') {
			end = new Point(start.y+1, start.x);
		}
		// 오른쪽
		else if(dir == 'R') {
			end = new Point(start.y, start.x+1);
		}
		// 왼쪽
		else if(dir == 'L') {
			end = new Point(start.y, start.x-1);
		}
		
		// range
		if(end.y < 0 || end.x < 0 || end.y > 10 || end.x > 10) {
			return null;
		}
		return end;
	}
}
