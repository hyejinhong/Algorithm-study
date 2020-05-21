package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class WorryOfBrian {

	static ArrayList<String> list = new ArrayList<>();
	static HashMap<Character, Boolean> map = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sentences = {
				"HaEaLaLaObWORLDb", 
//				"SpIpGpOpNpGJqOqA", 
//				"AxAxAxAoBoBoB",
//				"bSaHaIaNaEaEbWcOcRcLcD"
		};
		
		for(int i=0; i<sentences.length; i++) {
			System.out.println(solution(sentences[i]));
		}
	}

	public static String solution(String sentence) {
		// 공백이 있으면 올바른 것 아님
		if(sentence.contains(" ")) {
			return "invalid";
		}
		
		String copy = sentence;

		while(!copy.equals("")) {
			char first = copy.charAt(0);
			
			// 첫 글자가 대문자인 경우
			if(first >= 'A' && first <= 'Z') {
				// 혹시 한글자짜리면 걍 끝임
				if(copy.length() == 1) {
					list.add(copy);
					copy = copy.replace(copy, "");
					break;
				}
				// 규칙 1을 만족하는지??
				// 첫번째 단어가 어디까지인지 인덱스를 찾아야 함.
				int index = copy.lastIndexOf(copy.charAt(1));
				String temp = rule1(copy, index);
				// 규칙 1에 유효하지 않음
				if(temp.equals("invalid")) {
					return temp;
				}
				
				// 만족하면 찾은 단어만큼 지움
				copy = copy.substring(index+2);
				
				// list에 저장
				list.add(temp);

//				// word가 규칙 1을 혹시 만족하는지 보자
//				String temp = rule1(word);
//				
//				// 규칙 1에 유효하지 않음
//				if(temp.equals("invalid")) {
//					return temp;
//				}
//				
//				// 다 만족하면
//				// 찾은 단어만큼 지움
//				copy = copy.replace(word, "");
//				copy = copy.substring(2);
//				
//				// list에 저장
//				list.add(word);

			}
			// 첫 글자가 소문자인 경우 (규칙 2)
			else if(first >= 'a' && first <= 'z') {
				int index = copy.lastIndexOf(first);
				String word = rule2(copy, first, index);
				
				// 규칙 2에 유효하지 않음
				if(word.equals("invalid")) {
					return word;
				}
				
				// word가 규칙 1을 혹시 만족하는지 보자
				String temp = rule1(word, word.length()-1);
				
				// 규칙 1에 유효하지 않음
				if(temp.equals("invalid")) {
					return temp;
				}
				
				// 다 만족하면
				// 찾은 단어만큼 지움
//				copy = copy.replace(word, "");
//				copy = copy.substring(2);
				copy = copy.substring(index+1);
				
				// list에 저장
				list.add(temp);
			}
		}
	
		String answer = "";
		for(int i=0; i<list.size(); i++) {
			answer += list.get(i) + " ";
		}
		return answer.trim();
	}
	
	public static boolean isOnlyRemoveBlank(String sentence) {
		for(int i=0; i<sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				return false;
			}
		}
		return true;
	}
	
	// 규칙 1에 따라 사이에 낀 특수문자를 제거하고 반환함
	public static String rule1(String sentence, int index) {
		if(sentence.length() == 1) {
			return sentence;
		}
		// 홀수 index가 모두 ch면 규칙 만족
		char ch = sentence.charAt(1);
		
		// 대문자면, 혹시 공백만 제거한건지 검사
		if(ch >= 'A' && ch <= 'Z') {
			if(isOnlyRemoveBlank(sentence)) {
				return sentence;
			}
		}

		// 혹시 이 특수문자를 이미 사용한 적이 있나
		if(map.containsKey(ch)) {
			return "invalid";
		}
		else {
			map.put(ch, true);
		}
		
		
		// 소문자면 검사
		for(int i=1; i<=index; i+=2) {
			char temp = sentence.charAt(i);
			
			if(temp != ch) {
				return "invalid";
			}
		}
		
		String ret = "";
		for(int i=0; i<=index+1; i+=2) {
			ret += sentence.charAt(i);
		}
		return ret;
	}
	
	// 규칙 2번에 따라 가운에 낀 글자를 반환함
	public static String rule2(String sentence, char sc, int index) {
		if(index == -1) {
			return "invalid";
		}
		// 혹시 이 특수문자를 이미 사용한 적이 있나
		if(map.containsKey(sc)) {
			return "invalid";
		}
		else {
			map.put(sc, true);
		}

		String word = sentence.substring(1, index);
		return word;
	}

}
