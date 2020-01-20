package algospot;

import java.util.*;

class Box {
	int mTime;
	int eTime;
	
	public Box(int mTime, int eTime) {
		this.mTime = mTime;
		this.eTime = eTime;
	}
	
	public int getEtime() {
		return this.eTime;
	}
}

public class LunchBox {

	static int n;
//	static int[] m = new int[10000];
//	static int[] e = new int[10000];
	static LinkedList<Box> boxes = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			
			int[] m = new int[n];
			int[] e = new int[n];
			for(int i=0; i<n; i++) {
				m[i] = scan.nextInt();
			}
			for(int i=0; i<n; i++) {
				e[i] = scan.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				boxes.add(new Box(m[i], e[i]));
			}
			
			System.out.println(solve());
			boxes.clear();
		}
	}

	// 먹는데 오래걸리는 것을 가장 먼저 데우는 것이 최적해
	public static int solve() {
		// 내림차순 정렬
		boxes.sort(Comparator.comparingInt(Box::getEtime).reversed());
		
		int beginEat = 0;
		int ret = 0;
		for(int i=0; i<boxes.size(); i++) {
			beginEat += boxes.get(i).mTime;
			ret = Math.max(ret, beginEat + boxes.get(i).eTime);
		}
		
		return ret;
	}
}
