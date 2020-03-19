package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_6603 {

	static int k;
	static int[] arr = new int[13];
	static boolean[] check = new boolean[13];
	static ArrayList<Integer> picked = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(stk.nextToken());
			if(k == 0) {
				break;
			}
			
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			
			pick(0);
			System.out.println();
		}
	}
	
	// arr[index] ���� ����Ͽ� �̴´�.
	public static void pick(int index) {
		// ����: 6���� �� �����
		if(picked.size() == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(picked.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=index; i<k; i++) {
			// ���� �� �� ������ ���
			if(!check[i]) {
				check[i] = true;
				picked.add(arr[i]);
				
				pick(i+1); // �� ���� ����
				
				check[i] = false;
				picked.remove(picked.size()-1);
			}
		}
	}

}
