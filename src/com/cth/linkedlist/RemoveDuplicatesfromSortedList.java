package com.cth.linkedlist;

import com.cth.linkedlist.ListNode;

public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ls1 = null;
        ListNode ls2 = null;
        ls1 = head;
        ls2 = ls1;
        while (ls1 != null) {
            if (ls2 == null || ls2.val != ls1.val) {
                ls1.next = ls2;
                ls1 = ls2;
            } else {
                ls2 = ls2.next;
            }
        }
        return head;
    }
}
