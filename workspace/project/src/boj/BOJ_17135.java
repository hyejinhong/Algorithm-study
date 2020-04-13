package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static class Enemy {
		int id;
		int y;
		int x;
		
		Enemy(int id, int y, int x) {
			this.id = id;
			this.y = y;
			this.x = x;
		}	
	}
	
	static int n, m, d;
	static int[][] map = new int[16][16];
	
	static boolean[] check = new boolean[15];
	static ArrayList<Integer> picked = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m= Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		pick(0);
		System.out.println(result);
	}
	
	// 궁수 세명 배치할 자리 뽑음
	public static void pick(int index) {
		// 기저: 3자리 다 뽑음
		if(picked.size() == 3) {
			// 턴 시작
			int count = attack();
			result = Math.max(result, count);
			return;
		}
		
		for(int i=index; i<m; i++) {
			if(!check[i]) {
				check[i] = true;
				picked.add(i);
				
				pick(i+1);
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}
	
	public static int attack() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		
		// map copy, 적 정보 저장
		int id = 0;
		int[][] copy = new int[n+1][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copy[i][j] = map[i][j];
				if(copy[i][j] == 1) {
					enemies.add(new Enemy(id++, i , j));
				}
			}
		}
		
		
		// 궁수 배치
		for(int i=0; i<picked.size(); i++) {
			int index = picked.get(i);
			copy[n][index] = 3; // 궁수있는 칸은 3으로 함
		}
		
		int count = 0; // 공격한 적
		
		// 적 없어질 때까지 진행
		while(!enemies.isEmpty()) {
			// 공격
			// 각각 궁수에 대해서
			ArrayList<Enemy> aList = new ArrayList<>(); // 공격할 리스트
			for(int i=0; i<picked.size(); i++) {
				// 공격
				Enemy e = selectEnemy(picked.get(i), enemies);
				if(e != null) {
					copy[e.y][e.x] = 0;
//					enemies.remove(e); // 같은 적 공격할 수도 있으니 여기서 제거하면 안됨
					if(!aList.contains(e)) {
						aList.add(e);
						count++;
					}
				}
			}
			
			// for문 밖에서 제거
			for(int i=0; i<aList.size(); i++) {
				Enemy attacked = aList.get(i);
				enemies.remove(attacked);
			}
			
			// 적 이동
			Enemy[] removeList = new Enemy[m];
			int rIndex = 0;
			for(int i=0; i<enemies.size(); i++) {
				Enemy e = enemies.get(i);
				e.y += 1;
				
				// 성이 있는 칸으로 이동 -> 제외
				if(e.y == n) {
					System.out.println(e.toString()+" 제거");
//					enemies.remove(e);
					removeList[rIndex++] = e;
					continue;
				}
				copy[e.y][e.x] = 1;
			}
			
			// for문 밖에서 제거
			for(int i=0; i<m; i++) {
				enemies.remove(removeList[i]);
			}
		}
		return count;
	}
	
	public static Enemy selectEnemy(int x, ArrayList<Enemy> enemies) {
		Enemy ret = null;
		int min = 9999;
		int savedX = 0;
		
		for(int i=0; i<enemies.size(); i++) {
			Enemy e = enemies.get(i);
			int dist = Math.abs(n-e.y) + Math.abs(x-e.x);
			
			if(min > dist && dist <= d) {
				min = dist;
				savedX = e.x;
				ret = e;
			}
			// 거리가 같은 게 있으면 왼쪽부터
			else if(min == dist && dist <= d) {
				ret = savedX > e.x ? e : ret;
			}
		}	
		return ret;
	}
	
}
