package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1991 {
	
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "value: " + value + ", left : " + left + ", right : " + right;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Node> graph = new ArrayList<>();
		HashMap<Character, Node> map = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			char parent = stk.nextToken().charAt(0);
			
			char left = stk.nextToken().charAt(0);
			Node leftNode = map.getOrDefault(left, new Node(left, null, null));
			map.put(left, leftNode);
			
			char right = stk.nextToken().charAt(0);
			Node rightNode = map.getOrDefault(right, new Node(right, null, null));
			map.put(right, rightNode);

			Node parentNode = map.getOrDefault(parent, new Node(parent, leftNode, rightNode));
			parentNode.left = leftNode;
			parentNode.right = rightNode;
			
			map.put(parent, parentNode);
			
			graph.add(new Node(parent, leftNode, rightNode));
			
		}
		
		preorder(map.get('A'));
		System.out.print("\n");
		inorder(map.get('A'));
		System.out.print("\n");
		postorder(map.get('A'));
	}
	
	// 전위순회 (루트 -> 왼쪽 -> 오른쪽)
	private static void preorder(Node current) {
		System.out.print(current.value);
		
		// 왼쪽
		if (current.left.value != '.')
			preorder(current.left);
		
		// 오른쪽
		if (current.right.value != '.')
			preorder(current.right);
	}
	
	// 중위순회 (왼쪽 -> 루트 -> 오른쪽)
	private static void inorder(Node current) {
		// 왼쪽
		if (current.left.value != '.')
			inorder(current.left);
		
		System.out.print(current.value);
		
		// 오른쪽
		if (current.right.value != '.')
			inorder(current.right);
	}
	
	// 후외순회 (왼쪽 -> 오른쪽 -> 루트)
	private static void postorder(Node current) {
		// 왼쪽
		if (current.left.value != '.')
			postorder(current.left);
		
		// 오른쪽
		if (current.right.value != '.')
			postorder(current.right);

		System.out.print(current.value);
	}
}
