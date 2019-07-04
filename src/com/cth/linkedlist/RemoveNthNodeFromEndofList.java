package com.cth.linkedlist;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ls1 = head;
        ListNode ls2 = head;
        for (int i = 0; i < n; i++) {
            if (ls2 != null) {
                ls2 = ls2.next;
            }
        }
        if (ls2 == null) {
            head = head.next;
        } else {
            while (ls2.next != null) {
                ls2 = ls2.next;
                ls1 = ls1.next;
            }
            ls1.next = ls1.next.next;
        }
        return head;
    }
}
