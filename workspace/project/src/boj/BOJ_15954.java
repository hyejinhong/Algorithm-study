package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15954 {

	static int n, k;
	static int[] arr = new int[500];
	
	static boolean[] check = new boolean[500];
	static ArrayList<Integer> picked = new ArrayList<>();
	static double min = Double.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int limit=k; limit<=n; limit++) {
			for(int index=0; index<=n-limit; index++) {
				pick(index, limit);
			}
		}

		System.out.println(min);
	}
	
	// ���ӵ� limit�� ������.
	public static void pick(int index, int limit) {
		// ����: limit�� �����
		if(picked.size() == limit) {
			double result = calculate(limit);
			min = Math.min(min, result);
			picked.clear();
			return;
		}
		
		// ���� limit�� �� ������µ� index �Ѿ������ ��ȿ
		if(index >= n) {
			return;
		}
		
		picked.add(index);
		pick(index+1, limit);
	}
	
	// ���õ� k���� ǥ�� ���� ��ȯ
	public static double calculate(int N) {
		
		// ������ ���ϱ� (m)
		double sum = 0;
		for(int i=0; i<N; i++) {
			int index = picked.get(i);
			sum += arr[index];
		}
		
		double m = sum / N; // ������
		
		// �л� ���ϱ�
		double d = 0; // �л�
		for(int i=0; i<N; i++) {
			int index = picked.get(i);
			
			d += Math.pow((arr[index] - m), 2);
		}
		d /= N;
		
		// ǥ������
		double ret = Math.sqrt(d);
		return ret;
	}
}
