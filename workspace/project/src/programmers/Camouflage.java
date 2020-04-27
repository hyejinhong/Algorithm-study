package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Camouflage {

	static HashMap<String, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {
				{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"}
		};
		
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
		// input
		for(int i=0; i<clothes.length; i++) {
			String name = clothes[i][0];
			String kind = clothes[i][1];
		
			if(hash.containsKey(kind)) {
				int value = hash.get(kind);
				value++;
				hash.put(kind, value);
			}
			else {
				hash.put(kind, 1);
			}
		}
		
		int answer = 1;
		
		Iterator<String> it = hash.keySet().iterator();
		while(it.hasNext()) {
			answer *= hash.get(it.next()) + 1;
		}
		return answer - 1; // 아무것도 안입으면 안되니 1 뺌
	}
	


}
