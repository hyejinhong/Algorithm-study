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
		// ������ ������ �ùٸ� �� �ƴ�
		if(sentence.contains(" ")) {
			return "invalid";
		}
		
		String copy = sentence;

		while(!copy.equals("")) {
			char first = copy.charAt(0);
			
			// ù ���ڰ� �빮���� ���
			if(first >= 'A' && first <= 'Z') {
				// Ȥ�� �ѱ���¥���� �� ����
				if(copy.length() == 1) {
					list.add(copy);
					copy = copy.replace(copy, "");
					break;
				}
				// ��Ģ 1�� �����ϴ���??
				// ù��° �ܾ ���������� �ε����� ã�ƾ� ��.
				int index = copy.lastIndexOf(copy.charAt(1));
				String temp = rule1(copy, index);
				// ��Ģ 1�� ��ȿ���� ����
				if(temp.equals("invalid")) {
					return temp;
				}
				
				// �����ϸ� ã�� �ܾŭ ����
				copy = copy.substring(index+2);
				
				// list�� ����
				list.add(temp);

//				// word�� ��Ģ 1�� Ȥ�� �����ϴ��� ����
//				String temp = rule1(word);
//				
//				// ��Ģ 1�� ��ȿ���� ����
//				if(temp.equals("invalid")) {
//					return temp;
//				}
//				
//				// �� �����ϸ�
//				// ã�� �ܾŭ ����
//				copy = copy.replace(word, "");
//				copy = copy.substring(2);
//				
//				// list�� ����
//				list.add(word);

			}
			// ù ���ڰ� �ҹ����� ��� (��Ģ 2)
			else if(first >= 'a' && first <= 'z') {
				int index = copy.lastIndexOf(first);
				String word = rule2(copy, first, index);
				
				// ��Ģ 2�� ��ȿ���� ����
				if(word.equals("invalid")) {
					return word;
				}
				
				// word�� ��Ģ 1�� Ȥ�� �����ϴ��� ����
				String temp = rule1(word, word.length()-1);
				
				// ��Ģ 1�� ��ȿ���� ����
				if(temp.equals("invalid")) {
					return temp;
				}
				
				// �� �����ϸ�
				// ã�� �ܾŭ ����
//				copy = copy.replace(word, "");
//				copy = copy.substring(2);
				copy = copy.substring(index+1);
				
				// list�� ����
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
	
	// ��Ģ 1�� ���� ���̿� �� Ư�����ڸ� �����ϰ� ��ȯ��
	public static String rule1(String sentence, int index) {
		if(sentence.length() == 1) {
			return sentence;
		}
		// Ȧ�� index�� ��� ch�� ��Ģ ����
		char ch = sentence.charAt(1);
		
		// �빮�ڸ�, Ȥ�� ���鸸 �����Ѱ��� �˻�
		if(ch >= 'A' && ch <= 'Z') {
			if(isOnlyRemoveBlank(sentence)) {
				return sentence;
			}
		}

		// Ȥ�� �� Ư�����ڸ� �̹� ����� ���� �ֳ�
		if(map.containsKey(ch)) {
			return "invalid";
		}
		else {
			map.put(ch, true);
		}
		
		
		// �ҹ��ڸ� �˻�
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
	
	// ��Ģ 2���� ���� ��� �� ���ڸ� ��ȯ��
	public static String rule2(String sentence, char sc, int index) {
		if(index == -1) {
			return "invalid";
		}
		// Ȥ�� �� Ư�����ڸ� �̹� ����� ���� �ֳ�
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
