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
		// 이 트리에 포함된 노드의 수
		int num = po.size();
		
		// 기저: 빈 트리면 종료
		if(po.isEmpty()) {
			return;
		}
		
		// 이 트리의 루트
		int root = po.get(0);
		
		// 이 트리의 왼쪽 서브트리의 크기를 찾기
		// 중위 탐색 결과에서 루트의 위치를 찾으면 알 수 있음
		int l = io.indexOf(root);
		
		// 이 트리의 오른쪽 서브트리의 크기를 찾기
		// 전체 노드 수에서 루트와 왼쪽 서브트리의 개수를 빼면 알 수 있음
		int r = num-1-l;
		
		// 왼, 오 서브트리의 순회 결과 출력
		printPostOrder(slice(po, 1, l+1), slice(io, 0, l));
		printPostOrder(slice(po, l+1, num), slice(io, l+1, num));
		
		// 후위 순회이므로 루트 마지막에 출력
		System.out.print(root + " ");
	}

}
