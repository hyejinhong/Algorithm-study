package leetcode;

public class LeetCode_92 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		};

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		
		reverseBetween(node1, 2, 4);
		
	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode cur1 = dummy;
		ListNode prev1 = null;
		
		for (int i=0; i<left; i++) {
			prev1 = cur1;
			cur1 = cur1.next;
		}
		
		// 거꾸로 연결
		ListNode cur2 = cur1;
		ListNode prev2 = prev1;
		ListNode temp;
		
		for(int i=left; i<=right; i++) {
			temp = cur2.next;
			cur2.next = prev2;
			prev2 = cur2;
			cur2 = temp;
		}
		
		prev1.next = prev2;
		cur1.next = cur2;
		return dummy.next;
	}
}
