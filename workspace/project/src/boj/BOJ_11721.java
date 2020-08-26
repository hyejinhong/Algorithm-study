package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11721 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int index = 0;
		while(true) {
			
			if(index+10 >= line.length()) {
				System.out.println(line.substring(index));
				break;
			}
			System.out.println(line.substring(index, index+10));
			index += 10;
		}
	}

}
