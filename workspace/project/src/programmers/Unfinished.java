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
			
			// �̹� ������ -> ��������
			if(hash.containsKey(name)) {
				int value = hash.get(name);
				value++;
				hash.put(name, value);
			}
			// ó�� ����
			else {
				hash.put(name, 1);
			}
			System.out.println(hash.toString());
		}
		
		// ������ ��� ����
		for(int i=0; i<completion.length; i++) {
			String name = completion[i];
			int value = hash.get(name);
			
			// �������� �ƴ� ���
			if(value == 1) {
				hash.remove(name);
			}
			// �̸� ���� �����
			else {
				value--;
				hash.put(name, value);
			}
		}
		
		// ����
		String answer = "";
		Iterator<String> it = hash.keySet().iterator();
		while(it.hasNext()) {
			answer = it.next();
		}
		
		return answer;
	}
}
