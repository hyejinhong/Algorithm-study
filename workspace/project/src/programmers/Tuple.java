package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(Arrays.toString(solution(s)));
	}
	
	public static int[] solution(String s) {		
		// 앞뒤 괄호 삭제
		s = s.substring(2, s.length()-2);
		s = s.replace("},{", "/");
		
		String[] piece = s.split("/");
				
		// 길이순 정렬 - 오름차순
		Arrays.sort(piece, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<piece.length; i++) {
			String[] temp = piece[i].split(",");
			
			for(int j=0; j<temp.length; j++) {
				int num = Integer.parseInt(temp[j]);
				
				if(!list.contains(num)) {
					list.add(num);
				}
			}
		}
		
		int[] answer = new int[piece.length];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
