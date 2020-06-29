package com.edmund.duntis.warmup.reverselist;

public class Solution {
	public ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode curNode = head;
		ListNode nextNode = head.next;
		ListNode newHead = head;
		head.next=null;
		
		



		



		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}