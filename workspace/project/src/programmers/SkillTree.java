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
			
			boolean flag = true; // ���ེų �����ߴ��� ����
			// �� Ʈ���� ���� �������
			for(int j=0; j<tree.length(); j++) {
				String letter = tree.substring(j, j+1);
				
				int index = -1;
				for(int k=0; k<list.size(); k++) {
					if(letter.equals(list.get(k).name)) {
						index = k;
						break;
					}
				}
				
				// �ƹ����� ����� �Ǵ� ��ų
				if(index == -1) {
					continue;
				}
				
				// ������ �ִ� ��ų -> ���� ��ų ������� üũ
				for(int k=0; k<index; k++) {
					Skill sk = list.get(k);
					// �ȹ��
					if(!sk.isLearned) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					// ���� ��ų�� �����.
					list.get(index).learn();
				}
				else {
					break;
				}

			}
			
			if(flag) {
				count++;
			}

			// �ʱ�ȭ
			for(int j=0; j<list.size(); j++) {
				list.get(j).isLearned = false;
			}
		}
		
		return count;
	}

}
