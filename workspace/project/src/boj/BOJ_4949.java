package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			// input
			String str = br.readLine();

			if (str.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			// ��� ���� �˻絹��
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				// ���� ��ȣ�̸�
				if (c == '(' || c == '[') {
					stack.push(c);
				}
				// �ݴ� ��ȣ (
				else if (c == ')') {
					if (!stack.isEmpty()) {
						char top = stack.pop();
						// ¦�� �� ������ ���� ����
						if (top != '(') {
							stack.push(top);
							break;
						}
					}
					// ��������� �ȵ���
					else {
						stack.push(c);
						break;
					}
				}
				// �ݴ� ��ȣ
				else if (c == ']') {
					if (!stack.isEmpty()) {
						char top = stack.pop();
						// ¦�� �� ������ ���� ����
						if (top != '[') {
							stack.push(top);
							break;
						}
					}
					// ��������� �ȵ���
					else {
						stack.push(c);
						break;
					}

				}
			}
			// ���� �������
			if (stack.isEmpty()) {
				// ��������
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
