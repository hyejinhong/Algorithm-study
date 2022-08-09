package leetcode;

import java.util.HashSet;

public class LeetCode_141 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node2;

		node1.next = node2;
//		System.out.println(hasCycle(node1));
		System.out.println(hasCycle(null));
	}

	public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> history = new HashSet<>();

        if(head == null)
            return false;
        
        ListNode curNode = head;
		
        while(curNode.next != null) {
			ListNode next = curNode.next;

			if(history.contains(next))
				return true;
            else {
				history.add(next);
                curNode = next;                
            }
		}
		return false;   
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}