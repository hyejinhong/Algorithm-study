package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CandidateKey {

	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList<Integer> picked = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
	static boolean[] check = new boolean[8];
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] relation = {
//				{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}
//		};
		
//		String[][] relation = {
//				{"100","ryan","music","2", "m"},
//				{"200","apeach","math","2", "f"},
//				{"300","tube","computer","3", "m"},
//				{"400","con","computer","4", "m"},
//				{"500","muzi","music","3", "m"},
//				{"600","apeach","music","2", "m"}
//		};
		
//		String[][] relation = {
//				{"b","2","a","a","b"},
//				{"b","2","7","1","b"},
//				{"1","0","a","a","8"},
//				{"7","5","a","a","9"},
//				{"3","0","a","f","9"}
//		};

		String[][] relation = {
				{"100","ryan","music","2", "m", "a"},
				{"200","apeach","math","2", "f", "b"},
				{"300","tube","computer","3", "m", "b"},
				{"400","con","computer","4", "m", "a"},
				{"500","muzi","music","3", "f", "a"},
				{"600","apeach","music","2", "f", "a"}
		};


		
		System.out.println(solution(relation));
	}
	
	public static int solution(String[][] relation) {
		int n = relation[0].length;
		for(int limit=1; limit<=n; limit++) {
			pick(n, 0, limit, relation);
			Arrays.fill(check, false);
			picked.clear();
		}
		
		return count;
	}

	// limit개의 속성을 고름
	public static void pick(int n, int index, int limit, String[][] relation) {
		// 기저: 다 뽑았네요
		if(picked.size() == limit) {
			// 후보키 되면
			if(isValidCandidate(relation) ) {
				System.out.println(picked.toString());
				count++;
			}
			return;
		}
		
		for(int i=index; i<n; i++) {
			if(!check[i]) {
				picked.add(i);
				check[i] = true;
				
				pick(n, i+1, limit, relation);
				
				picked.remove(picked.size()-1);
				check[i] = false;
			}
		}
	}
	
	// 후보키가 되는지 알아보자.
	public static boolean isValidCandidate(String[][] relation) {
		
		// 1. 유일성 검사
		for(int i=0; i<relation.length; i++) {
			String key = "";
			for(int j=0; j<picked.size(); j++) {
				key += relation[i][picked.get(j)] + "/";
			}
			// 이미 이 키가 존재함?? -> 후보키 안됨
			if(map.containsKey(key)) {
				return false;
			}
			else {
				map.put(key, 0);
			}
		}
		
		map.clear();
		
		// 2. 최소성 검사
		// 지금까지 저장한 후보키에 대해서
		for(int i=0; i<candidates.size(); i++) {
			ArrayList<Integer> candi = candidates.get(i);
			
			if(picked.containsAll(candi)) {
				return false;
			}
//			boolean[] mark = new boolean[relation[0].length];
//			
//			// 어떤 열 사용하는지 표시
//			for(int j=0; j<candi.length(); j++) {
//				int cIndex = Integer.parseInt(candi.substring(j, j+1));
//				mark[cIndex] = true;
//			}
//			
//			// 현재 선택한 열들이 그거에 얼마나 포함되는지를 검사
//			int cnt = 0;
//			for(int j=0; j<picked.size(); j++) {
//				int kIndex = picked.get(j);
//				if(mark[kIndex]) {
//					cnt++;
//				}
//			}
//			
//			// 부분집합임
//			if(cnt >= candi.length()) {
//				return false;
//			}
		}

		// 모두 통과, 후보키에 저장
//		String cur = "";
//		for(int i=0; i<picked.size(); i++) {
//			cur += picked.get(i);
//		}
		// call by Reference라서 복사해서 집어넣어야함
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<picked.size(); i++) {
			temp.add(picked.get(i));
		}
		candidates.add(temp);
		System.out.println("candidates: " + candidates.toString());
		return true;
	}
	
	
}
