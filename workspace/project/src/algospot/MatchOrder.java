package algospot;

import java.util.*;
public class MatchOrder {
	
	static int n;
	static int[] russian = new int[100];
	static int[] korean = new int[100];
	static boolean[] check = new boolean[100]; // �ѱ� ���� ���ߵǾ����� üũ
	static int result = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			result = 0;
			Arrays.fill(check, false);
			
			for(int i=0; i<n; i++) {
				russian[i] = scan.nextInt();
			}
			for(int i=0; i<n; i++) {
				korean[i] = scan.nextInt();
			}
			order(0);
		}
	}
	
	// �̱� �� �ִ� �������� �ε��� �迭 ��ȯ
	public static int[] pick(int index) {
		int[] ret = new int[n];
		int t = 0;
		Arrays.fill(ret, -1);
		
		for(int i=0; i<n; i++) {
			if(!check[i]) {
//				System.out.println("korean: " + korean[i] + ", " + "russian: " + russian[index]);
				if(korean[i] >= russian[index]) {
					ret[t++] = i;
				}
			}
		}
		
		return ret;
	}
	
	public static void order(int index) {
		if(index == n) {
			System.out.println(result);
			return;
		}
		
		// �̱� �� �ִ� ���� �� �������� ���� ���� ���� ����
		int[] picked = pick(index);
		
		// �̱� �� �ִ� ������ ����
		if(picked[0] == -1) {
			int min = Integer.MAX_VALUE;
			int temp = -1;
			
			for(int i=0; i<n; i++) {
				// ���� ���� �� �� ���� ��
				if(!check[i]) {
					// ������ �ּ�
					if(min >= korean[i]) {
						min = korean[i];
						temp = i;
					}
				}
			}
			check[temp] = true;
			order(index+1);
			return;
		}
		
		// ���� ���� ������ ����
		int min = korean[picked[0]];
		int temp = 0;
		for(int i=0; i<n; i++) {
			if(picked[i] != -1) {
				if(min >= korean[picked[i]]) {
					min = korean[picked[i]];
					temp = picked[i];
				}
			}
		}
		check[temp] = true;
		result++;
		order(index+1);
		return;
	}
}
