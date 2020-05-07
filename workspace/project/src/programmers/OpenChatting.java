package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChatting {

	static class Message {
		String id;
		String type;
		
		Message(String id, String type) {
			this.id = id;
			this.type = type;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String ret = map.get(id);
			switch(type) {
			case "Enter":
				ret += "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
				break;
			case "Leave":
				ret += "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
				break;
			}
			return ret;
		}
	}
		
	static HashMap<String, String> map = new HashMap<>(); // id-nickname
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
		ArrayList<Message> list = new ArrayList<>();
		
		for(int i=0; i<record.length; i++) {
			String[] oper = record[i].split(" ");
			switch(oper[0]) {
			case "Enter":
				map.put(oper[1], oper[2]);
				list.add(new Message(oper[1], oper[0]));
				break;
			case "Leave":
				list.add(new Message(oper[1], oper[0]));
				break;
			case "Change":
				map.put(oper[1], oper[2]);
				break;
			}
		}
		
		String[] answer = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).toString();
		}
		return answer;
	}
}
