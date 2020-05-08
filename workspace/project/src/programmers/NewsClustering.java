package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class NewsClustering {

	static final int NUMBER = 65536;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str1 = "FRANCE";
//		String str2 = "french";
		
//		String str1 = "handshake";
//		String str2 = "shake hands";

//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
//
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";

		
		System.out.println(solution(str1, str2));
	}
	
	public static int solution(String str1, String str2) {
		// 대문자로 통일
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		// 잘라서 원소를 가져옴
		HashMap<String, Integer> map1 = getElement(str1);
		HashMap<String, Integer> map2 = getElement(str2);

		// 교집합, 합집합 구하기
		HashMap<String, Integer> inter = getIntersection(map1, map2);
		HashMap<String, Integer> union = getUnion(map1, map2);
		
		int answer = (int) (calculate(inter, union) * NUMBER);
		return answer;
	}
	
	public static HashMap<String, Integer> getElement(String str) {
		HashMap<String, Integer> ret = new HashMap<>();
		
		for(int i=0; i<str.length()-1; i++) {
			// 두글자 자르고
			String piece = str.substring(i, i+2);
			
			// 영어로만 되어있는지
			if(piece.matches("^[A-Z]*$")) {
				// 이미 들어있는지
				if(ret.containsKey(piece)) {
					int value = ret.get(piece);
					ret.put(piece, ++value);
				}
				else {
					ret.put(piece, 1);
				}
			}
		}
		return ret;
	}
	
	// 교집합 반환
	public static HashMap<String, Integer> getIntersection
	(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
		HashMap<String, Integer> ret = new HashMap<>();
		
		Iterator<String> it = map1.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			
			// map2도 이것을 가지고 있으면 작은 값
			if(map2.containsKey(key)) {
				int val1 = map1.get(key);
				int val2 = map2.get(key);
				ret.put(key, Math.min(val1, val2));
			}
		}
		return ret;
	}
	
	// 합집합
	public static HashMap<String, Integer> getUnion
	(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
		HashMap<String, Integer> ret = new HashMap<>();
		
		ret.putAll(map1);
		
		Iterator<String> it = map2.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			
			// 이미 있으면 더 큰값..
			if(ret.containsKey(key)) {
				int val1 = ret.get(key);
				int val2 = map2.get(key);
				ret.put(key, Math.max(val1, val2));
			}
			// 아니면 새로 넣기
			else {
				int val = map2.get(key);
				ret.put(key, val);
			}
		}
		return ret;
	}

	public static double calculate
	(HashMap<String, Integer> inter, HashMap<String, Integer> union) {
		
		Iterator<String> it1 = inter.keySet().iterator();
		double a = 0;
		while(it1.hasNext()) {
			String key = it1.next();
			a += inter.get(key);
		}
		
		Iterator<String> it2 = union.keySet().iterator();
		double b = 0;
		while(it2.hasNext()) {
			String key = it2.next();
			b += union.get(key);
		}
		
		if(a == 0 && b == 0) {
			return 1;
		}
		
		double ret = a/b;
		return ret;
	}
	
}
