package com.cth.backup.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode ls = null;
        if (l1 == null) {
            return l2;
        } else if (l2 != null) {
            return l1;
        }

        if (l1.val > l2.val) {
            head = l2;
            ls = l2;
            l2 = l2.next;
        } else {
            head = l1;
            ls = l1;
            l1 = l1.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ls.next = l2;
                ls = ls.next;
                l2 = l2.next;
            } else {
                ls.next = l1;
                ls = ls.next;
                l1 = l1.next;
            }
        }
        if (l1 == null || l2 == null) {
            ListNode remain = l1;
            if (l2 == null) {
                remain = l2;
            }
            while (remain != null) {
                ls.next = remain;
                ls = ls.next;
                remain = remain.next;
            }
        }
        return head;
    }
}
