package com.cth.decode.LinkList.medium;

import com.cth.decode.LinkList.medium.ListNode;;
public class InsertionSortList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode emptyhead = new ListNode(0);
		emptyhead.next = head;
		ListNode befUnSortBegin = emptyhead, unSortBegin = befUnSortBegin.next;
		while (unSortBegin != null) {
			ListNode insertPlace = emptyhead.next;
			ListNode beforeInsert = emptyhead;
			while (insertPlace != unSortBegin) {
				if (insertPlace.val <= unSortBegin.val) {
					insertPlace = insertPlace.next;
					beforeInsert = beforeInsert.next;
				} else {
					break;
				}
			}
			if (insertPlace == unSortBegin) {
				unSortBegin = unSortBegin.next;
				befUnSortBegin = befUnSortBegin.next;
			} else {
				befUnSortBegin.next = unSortBegin.next;
				unSortBegin.next = beforeInsert.next;
				beforeInsert.next = unSortBegin;
				unSortBegin = befUnSortBegin.next;
			}
		}
		return emptyhead.next;
	}
}
