package project;

import java.util.*;

public class BOJ_10974 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		ArrayList<Integer> picked = new ArrayList<>(); // ���õ� ��
		boolean[] check = new boolean[n+1]; // ���õ��� üũ

		pick(n, picked, check);
		
	}
		
	public static void pick(int n, ArrayList<Integer> picked, boolean[] check) {
		// ����: ������ŭ �����ϸ� ����ϰ� ����
		if(picked.size() == n) {
			printArray(picked);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i+1]) {
				check[i+1] = true;
				picked.add(i+1);
				pick(n, picked, check);
				picked.remove(picked.size()-1);
				check[i+1] = false;
			}
		}
	}
	
	public static void printArray(ArrayList<Integer> picked) {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}
}
