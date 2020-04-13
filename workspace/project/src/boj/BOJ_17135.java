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
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+y+", "+x+")";
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
	
	// 叡呪 室誤 壕帖拝 切軒 嗣製
	public static void pick(int index) {
		// 奄煽: 3切軒 陥 嗣製
		if(picked.size() == 3) {
			// 渡 獣拙
			System.out.println(picked.toString());
			print(map);
			int count = attack();
			result = Math.max(result, count);
			System.out.println("けしけしけしけしけしけしけしけし");
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
		
		// map copy, 旋 舛左 煽舌
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
		
		
		// 叡呪 壕帖
		for(int i=0; i<picked.size(); i++) {
			int index = picked.get(i);
			copy[n][index] = 3; // 叡呪赤澗 牒精 3生稽 敗
		}
		
		int count = 0; // 因維廃 旋
		
		// 旋 蒸嬢霜 凶猿走 遭楳
		while(!enemies.isEmpty()) {
			// 因維
			// 唖唖 叡呪拭 企背辞
			ArrayList<Enemy> aList = new ArrayList<>(); // 因維拝 軒什闘
			for(int i=0; i<picked.size(); i++) {
				// 因維
				Enemy e = selectEnemy(picked.get(i), enemies);
				if(e != null) {
					System.out.println("("+e.y+", "+e.x+") 因維");
					copy[e.y][e.x] = 0;
//					enemies.remove(e); // 旭精 旋 因維拝 呪亀 赤生艦 食奄辞 薦暗馬檎 照喫
					if(!aList.contains(e)) {
						aList.add(e);
						count++;
					}
				}
			}
			
			// for庚 鉱拭辞 薦暗
			for(int i=0; i<aList.size(); i++) {
				Enemy attacked = aList.get(i);
				enemies.remove(attacked);
			}
			
			System.out.println("因維");
			print(copy);
			System.out.println("************************");
			// 旋 戚疑
			for(int[] row : copy) {
				Arrays.fill(row, 0);
			}
			
			for(int i=0; i<m; i++ ) {
				copy[n][i] = 2;
			}
			for(int i=0; i<picked.size(); i++) {
				int index = picked.get(i);
				copy[n][index] = 3; // 叡呪赤澗 牒精 3生稽 敗
			}

			Enemy[] removeList = new Enemy[m];
			int rIndex = 0;
			for(int i=0; i<enemies.size(); i++) {
				Enemy e = enemies.get(i);
				e.y += 1;
				
				// 失戚 赤澗 牒生稽 戚疑 -> 薦須
				if(e.y == n) {
					System.out.println(e.toString()+" 薦暗");
//					enemies.remove(e);
					removeList[rIndex++] = e;
					continue;
				}
				copy[e.y][e.x] = 1;
			}
			
			// for庚 鉱拭辞 薦暗
			for(int i=0; i<m; i++) {
				enemies.remove(removeList[i]);
			}
			
			System.out.println("戚疑");
			print(copy);
			System.out.println("count: "+count);
			System.out.println("Enemy 薄伐");
			for(int i=0; i<enemies.size(); i++) {
				System.out.println(enemies.get(i).toString());
			}
			System.out.println("************************");
		}
		return count;
	}
	
	public static Enemy selectEnemy(int x, ArrayList<Enemy> enemies) {
		Enemy ret = null;
		int min = 9999;
		int savedX = 0;
		
		for(int i=0; i<enemies.size(); i++) {
			Enemy e = enemies.get(i);
			int sy = e.y;
			int sx = e.x;
			int dist = Math.abs(n-e.y) + Math.abs(x-e.x);
			
			if(min > dist && dist <= d) {
				min = dist;
				savedX = e.x;
				ret = e;
			}
			// 暗軒亜 旭精 惟 赤生檎 図楕採斗
			else if(min == dist && dist <= d) {
				ret = savedX > e.x ? e : ret;
			}
		}
		
		return ret;
	}
	
	public static void print(int[][] copy) {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}
}
