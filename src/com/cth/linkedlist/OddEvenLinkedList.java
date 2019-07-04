package com.cth.linkedlist;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddend = null;
        ListNode evenend = null;
        ListNode flag = null;
        flag = head;
        oddend = head;
        if (flag.next != null) {
            evenend = flag.next;
            flag = flag.next.next;
        } else {
            flag = null;
        }
        while (flag != null) {
            if (flag.next != null) {
                ListNode ls = new ListNode(flag.val);
                flag.val = flag.next.val;
                evenend = flag;
                flag.next = flag.next.next;
                ls.next = oddend.next;
                oddend.next = ls;
                oddend = ls;
                if (flag.next != null) {
                    flag = flag.next;
                } else {
                    flag = null;
                }
            } else {
                ListNode ls = new ListNode(flag.val);
                ls.next = oddend.next;
                oddend.next = ls;
                oddend = ls;
                evenend.next = null;
                flag = null;
            }
        }
        return head;
    }
}
