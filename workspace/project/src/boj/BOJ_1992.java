package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1992 {

	static BufferedReader br;
	static BufferedWriter bw;
	static int n;
	static int[][] display = new int[65][65];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				display[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		cut(0, 0, n);
		bw.newLine();
		bw.flush();
	}
	
	public static void cut(int y, int x, int width) throws IOException {
		// ����: ������ ���� ���ڸ����� �̷����
		if(sameNumber(y, x, width)) {
			int num = display[y][x];
			if(num == 0) {
				bw.write("0");
				return;
			}
			else {
				bw.write("1");
				return;
			}
		}
		
		// �ٸ� ���ڰ� ���������� �߶�� ��
		bw.write("(");
		cut(y, x, width/2);
		cut(y, x+width/2, width/2);
		cut(y+width/2, x, width/2);
		cut(y+width/2, x+width/2, width/2);
		bw.write(")");
	}
	
	// (x, y)���� �����ϴ� width ������ �κ� ������ ��� ���� ���ڷ� �̷���� �ִ��� �˻�
	public static boolean sameNumber(int y, int x, int width) {
		int num = display[y][x];
		
		for(int i=y; i<y+width; i++) {
			for(int j=x; j<x+width; j++) {
				if(num != display[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
