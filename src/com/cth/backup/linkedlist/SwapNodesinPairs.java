package com.cth.backup.linkedlist;


public class SwapNodesinPairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ls1 = head;
        ListNode ls2 = head.next;
        if (ls2 != null) {
            head = ls2;
            while (true) {
                if (ls2.next != null) {
                    if (ls2.next.next == null) {
                        ls1.next = ls2.next;
                        ls2.next = ls1;
                        break;
                    } else {
                        ListNode ls = ls2.next;
                        ls1.next = ls2.next.next;
                        ls2.next = ls1;
                        ls1 = ls;
                        ls2 = ls.next;
                    }
                } else {
                    ls2.next = ls1;
                    ls1.next = null;
                    break;
                }
            }
        }
        return head;
    }
}
