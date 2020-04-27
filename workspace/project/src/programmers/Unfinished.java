package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Unfinished {

	static HashMap<String, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {
				"mislav", "mislav", "mislav", "ana"
		};
		
		String[] completion = {
				"mislav", "mislav", "mislav"
		};
		
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		// input
		for(int i=0 ;i<participant.length; i++) {
			String name = participant[i];
			
			// 이미 저장함 -> 동명이인
			if(hash.containsKey(name)) {
				int value = hash.get(name);
				value++;
				hash.put(name, value);
			}
			// 처음 저장
			else {
				hash.put(name, 1);
			}
			System.out.println(hash.toString());
		}
		
		// 완주한 사람 제거
		for(int i=0; i<completion.length; i++) {
			String name = completion[i];
			int value = hash.get(name);
			
			// 동명이인 아닌 사람
			if(value == 1) {
				hash.remove(name);
			}
			// 이름 같은 사람들
			else {
				value--;
				hash.put(name, value);
			}
		}
		
		// 정답
		String answer = "";
		Iterator<String> it = hash.keySet().iterator();
		while(it.hasNext()) {
			answer = it.next();
		}
		
		return answer;
	}
}
