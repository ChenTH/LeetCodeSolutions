package com.cth.linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode end = head;
        ListNode ls = head.next;
        while (true) {
            if (ls != null) {
                if (ls.val == val) {
                    ls = ls.next;
                } else {
                    end.next = ls;
                    end = ls;
                    ls = ls.next;
                }
            } else {
                end.next = ls;
                break;
            }
        }
        return head;
    }
}
