package algospot;

import java.util.*;
public class Traversal {

	static int n;
	static ArrayList<Integer> preorder = new ArrayList<>();
	static ArrayList<Integer> inorder = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		
		for(int test=1; test<=c; test++) {
			n = scan.nextInt();
			
			for(int i=0; i<n; i++) {
				preorder.add(scan.nextInt());
			}
			for(int i=0; i<n; i++) {
				inorder.add(scan.nextInt());
			}
			
			printPostOrder(preorder, inorder);
			System.out.println();
			preorder.clear();
			inorder.clear();
		}
	}
	
	public static List<Integer> slice(List<Integer> list, int a, int b) {
		return list.subList(a, b);
	}
	
	public static void printPostOrder(List<Integer> po, List<Integer> io) {
		// �� Ʈ���� ���Ե� ����� ��
		int num = po.size();
		
		// ����: �� Ʈ���� ����
		if(po.isEmpty()) {
			return;
		}
		
		// �� Ʈ���� ��Ʈ
		int root = po.get(0);
		
		// �� Ʈ���� ���� ����Ʈ���� ũ�⸦ ã��
		// ���� Ž�� ������� ��Ʈ�� ��ġ�� ã���� �� �� ����
		int l = io.indexOf(root);
		
		// �� Ʈ���� ������ ����Ʈ���� ũ�⸦ ã��
		// ��ü ��� ������ ��Ʈ�� ���� ����Ʈ���� ������ ���� �� �� ����
		int r = num-1-l;
		
		// ��, �� ����Ʈ���� ��ȸ ��� ���
		printPostOrder(slice(po, 1, l+1), slice(io, 0, l));
		printPostOrder(slice(po, l+1, num), slice(io, l+1, num));
		
		// ���� ��ȸ�̹Ƿ� ��Ʈ �������� ���
		System.out.print(root + " ");
	}

}
