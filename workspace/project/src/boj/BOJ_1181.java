package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class BOJ_1181 {
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		// input
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(!list.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				// ±Ê¿Ã∑Œ
				int result = o1.length() - o2.length();
				if(result == 0) {
					return o1.compareTo(o2);
				}
				else {
					return result;
				}
			}
		});
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
