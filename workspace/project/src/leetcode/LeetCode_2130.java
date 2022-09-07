package leetcode;

public class LeetCode_2130 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
//		ListNode head = new ListNode(5);
//		ListNode node1 = new ListNode(4);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(1);
		
//		ListNode head = new ListNode(4);
//		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
		
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(100000);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
		head.next = node1;
//		node1.next = node2;
//		node2.next = node3;

		System.out.println(pairSum(head));
	}

	public static int pairSum(ListNode head) {
		int index = 0;
		int[] values = new int[100001];
		ListNode curNode = head;

		while (curNode != null) {
			values[index++] = curNode.val;
			curNode = curNode.next;
		}

		// index == size of ListNode
		int maxSum = 0;
		// twin인 두 인덱스의 합은 index-1 일 것이에요
		for (int i = 0; i <= (index - 1) / 2; i++) {
			int twin1 = i;
			int twin2 = index-1-i;
			
			maxSum = Math.max(maxSum, values[twin1]+values[twin2]);
		}
		
		return maxSum;
	}
}
