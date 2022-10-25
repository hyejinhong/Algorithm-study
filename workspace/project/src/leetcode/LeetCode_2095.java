package leetcode;

public class LeetCode_2095 {

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(3);
//		ListNode node3 = new ListNode(4);
//		ListNode node4 = new ListNode(7);
//		ListNode node5 = new ListNode(1);
//		ListNode node6 = new ListNode(2);
//		ListNode node7 = new ListNode(6);
//		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
		
//		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(1);
//		node1.next = node2;
		
//		print(node1);
		print(deleteMiddle(node1));
	}
	
	public static ListNode deleteMiddle(ListNode head) {
		
		if (head == null || head.next == null)
			return null;
		
		int count = 1;
		ListNode cur = head;
		while(cur.next != null) {
			count++;
			cur = cur.next;
		}
		
		int middle = count / 2;
		cur = head;
		for(int i=0; i<middle-1; i++) {
			cur = cur.next;
		}

		cur.next = cur.next.next;
		return head;
	}
	
	public static void print(ListNode head) {
		while (head.next != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print(head.val);
	}

}
