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

	// limit���� �Ӽ��� ��
	public static void pick(int n, int index, int limit, String[][] relation) {
		// ����: �� �̾ҳ׿�
		if(picked.size() == limit) {
			// �ĺ�Ű �Ǹ�
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
	
	// �ĺ�Ű�� �Ǵ��� �˾ƺ���.
	public static boolean isValidCandidate(String[][] relation) {
		
		// 1. ���ϼ� �˻�
		for(int i=0; i<relation.length; i++) {
			String key = "";
			for(int j=0; j<picked.size(); j++) {
				key += relation[i][picked.get(j)] + "/";
			}
			// �̹� �� Ű�� ������?? -> �ĺ�Ű �ȵ�
			if(map.containsKey(key)) {
				return false;
			}
			else {
				map.put(key, 0);
			}
		}
		
		map.clear();
		
		// 2. �ּҼ� �˻�
		// ���ݱ��� ������ �ĺ�Ű�� ���ؼ�
		for(int i=0; i<candidates.size(); i++) {
			ArrayList<Integer> candi = candidates.get(i);
			
			if(picked.containsAll(candi)) {
				return false;
			}
//			boolean[] mark = new boolean[relation[0].length];
//			
//			// � �� ����ϴ��� ǥ��
//			for(int j=0; j<candi.length(); j++) {
//				int cIndex = Integer.parseInt(candi.substring(j, j+1));
//				mark[cIndex] = true;
//			}
//			
//			// ���� ������ ������ �װſ� �󸶳� ���ԵǴ����� �˻�
//			int cnt = 0;
//			for(int j=0; j<picked.size(); j++) {
//				int kIndex = picked.get(j);
//				if(mark[kIndex]) {
//					cnt++;
//				}
//			}
//			
//			// �κ�������
//			if(cnt >= candi.length()) {
//				return false;
//			}
		}

		// ��� ���, �ĺ�Ű�� ����
//		String cur = "";
//		for(int i=0; i<picked.size(); i++) {
//			cur += picked.get(i);
//		}
		// call by Reference�� �����ؼ� ����־����
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0; i<picked.size(); i++) {
			temp.add(picked.get(i));
		}
		candidates.add(temp);
		System.out.println("candidates: " + candidates.toString());
		return true;
	}
	
	
}
