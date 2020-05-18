package programmers;

import java.util.ArrayList;

public class SkillTree {

	static class Skill {
		String name;
		boolean isLearned;
		
		Skill(String name) {
			this.name = name;
			this.isLearned = false;
		}
		
		public void learn() {
			this.isLearned = true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int count = 0;
		
		ArrayList<Skill> list = new ArrayList<>();
		
		// input
		for(int i=0; i<skill.length(); i++) {
			list.add(new Skill(skill.substring(i, i+1)));
		}

		for(int i=0; i<skill_trees.length; i++) {
			String tree = skill_trees[i];
			String s = skill_trees[i].substring(0, 1);
			
			boolean flag = true; // 선행스킬 만족했는지 여부
			// 이 트리의 글자 순서대로
			for(int j=0; j<tree.length(); j++) {
				String letter = tree.substring(j, j+1);
				
				int index = -1;
				for(int k=0; k<list.size(); k++) {
					if(letter.equals(list.get(k).name)) {
						index = k;
						break;
					}
				}
				
				// 아무때나 배워도 되는 스킬
				if(index == -1) {
					continue;
				}
				
				// 순서가 있는 스킬 -> 선행 스킬 배웠는지 체크
				for(int k=0; k<index; k++) {
					Skill sk = list.get(k);
					// 안배움
					if(!sk.isLearned) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					// 지금 스킬도 배워라.
					list.get(index).learn();
				}
				else {
					break;
				}

			}
			
			if(flag) {
				count++;
			}

			// 초기화
			for(int j=0; j<list.size(); j++) {
				list.get(j).isLearned = false;
			}
		}
		
		return count;
	}

}
