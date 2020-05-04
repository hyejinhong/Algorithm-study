package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static class Home {
		int y;
		int x;
		int dist;
		
		Home(int y, int x) {
			this.y = y;
			this.x = x;
			dist = 99999;
		}
	}
	
	static int n, m;
	static int[][] map = new int[51][51];
	
	static boolean[][] check = new boolean[51][51];

	static int min = 9999;
	
	static ArrayList<Home> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				// 집 저장
				if(map[i][j] == 1) {
					list.add(new Home(i, j));
				}
			}
		}
		
		// 치킨집 고르기
		for(int i=1; i<=m; i++) {
			pick(1, i, 0);
		}
		
		System.out.println(min);
	}
	
	// limit개의 폐업시키지 않을 치킨집 고르기
	public static void pick(int index, int limit, int count) {
		// 기저 : limit개 다 고름
		if(count == limit) {
			int result = getResult();
			min = Math.min(min, result);
			return;
		}
		
		// 다 안골랐는데 맵 범위 넘어가면 어떡함??
		if(index > n*n) {
			// 무효지
			return;
		}
		
		int row = index%n != 0 ? index/n + 1 : index/n;
		int col = index%n != 0 ? index%n : n;
		
//		System.out.println("row: " + row +", col: " + col);
		// 치킨집이고 아직 선택되지 않음
		if(map[row][col] == 2 && !check[row][col]) {
			check[row][col] = true;
			map[row][col] = 3;
			
			pick(index+1, limit, count+1);
			
			check[row][col] = false;
			map[row][col] = 2;
			
			pick(index+1, limit, count);
		}
		// 아니면 다음
		else {
			pick(index+1, limit, count);
		}
		
	}
	
	// 각 집의 치킨 거리 계산
	public static void setChickenDistanace() {
		// 모든 집 초기화 먼저 해줘야함
		
		// 모든 집에 대해
		for(int i=0; i<list.size(); i++) {
			Home h = list.get(i);
			h.dist = 99999;
			
			for(int row=1; row<=n; row++) {
				for(int col=1; col<=n; col++) {
					// 선택된 치킨집이면
					if(map[row][col] == 3) {
						int dist = calculate(h, row, col);
						h.dist = Math.min(dist, h.dist);
					}
				}
			}
		}
	}
	
	public static int calculate(Home home, int y, int x) {
		int dist = Math.abs(home.y - y) + Math.abs(home.x - x);
		return dist;
	}
	
	// 도시의 치킨거리 결과 반환
	public static int getResult() {
		// 각 집 치킨거리 세팅
		setChickenDistanace();
		
		// 모든 치킨거리의 합
		int ret = 0;
		for(int i=0; i<list.size(); i++) {
			Home h = list.get(i);
			
			ret += h.dist;
		}
		
		return ret;
	}

}
