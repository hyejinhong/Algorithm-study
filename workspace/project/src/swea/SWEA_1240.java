package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1240 {

	static int n, m;
	static int[][] map = new int[50][100];
	
	static String[] match = {
			"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"
	};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=t; test++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(str.substring(j, j+1));
				}
			}
						
			System.out.println("#" + test + " " + solve());
		}
	}
	
	public static int solve() {
		// ��ȣ�� ���۵Ǵ� �� ã��
		int row = getStartRow();
		
		// ��ȣ�� ������ �� ã��
		int col = getLastColumn(row);
		
		// 7���ھ� �ڸ���
		String[] encoded = new String[8];
		int count = 0; // �����
		int index = 0; // ���� �迭 �ε���
		String str = "";
		
		for(int i=col-56+1; i<=col; i++) {
			count++;
			if(count == 7) {
				str += map[row][i];
				encoded[index++] = str;
				str = "";
				count = 0;
			}
			else {
				str += map[row][i];
			}
		}

		// �ص��ϱ�
		String decoded = decode(encoded);
		
		// ��ȿ��?
		if(isValid(decoded)) {
			return getSum(decoded);
		}
		else {
			return 0;
		}
	}
	
	public static int getStartRow() {
		int row = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1) {
					row = i;
					return row;
				}
			}
		}
		
		return row;
	}
	
	public static int getLastColumn(int row) {
		int col = 0;
		
		for(int i=0; i<m; i++) {
			if(map[row][i] == 1) {
				col = i;
			}
		}
		
		return col;
	}
	
	public static String decode(String[] encoded) {
		String ret = "";
		
		// ��ġ�ϴ� ���� ã��
		for(int i=0; i<encoded.length; i++) {
			for(int j=0; j<match.length; j++) {
				if(encoded[i].equals(match[j])) {
					ret += j;
					break;
				}
			}
		}
		
		return ret;
	}

	public static boolean isValid(String decoded) {
		int oddSum = 0; // Ȧ�� �ڸ� �� 
		int evenSum = 0; // ¦�� �ڸ� ��
		
		for(int i=0; i<decoded.length()-1; i++) {
			// Ȧ���ڸ� �� (index�� ¦��)
			if(i%2 == 0) {
				oddSum += Integer.parseInt(decoded.substring(i, i+1));
			}
			else {
				evenSum += Integer.parseInt(decoded.substring(i, i+1));
			}
		}
		
		int validCode = Integer.parseInt(decoded.substring(7));
		
		int result = (oddSum*3) + evenSum + validCode;
		
		if(result%10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getSum(String decoded) {
		int sum = 0;
		
		for(int i=0; i<decoded.length(); i++) {
			sum += Integer.parseInt(decoded.substring(i, i+1));
		}
		
		return sum;
	}
}
