package com.cth.linkedlist;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode ls = head;
        while (ls != null) {
            count++;
            ls = ls.next;
        }
        if (count == 0 || count == 1) {
            return true;
        }//空串或者只有一个的串为回文
        int mid = count / 2;
        ls = head;
        for (int i = 0; i < mid; i++) {
            ls = ls.next;
        }

        ListNode ls1 = null;
        ListNode ls2 = null;
        while (head != ls) {
            ls1 = head;
            head = head.next;
            ls1.next = ls2;
            ls2 = ls1;
        }//反转前半段

        if (count % 2 != 0) {
            ls = ls.next;
        }//找到后半段的头
        for (int i = 0; i < mid; i++) {
            if (ls1.val != ls.val) {
                return false;
            }
            ls1 = ls1.next;
            ls = ls.next;
        }
        return true;
    }
}
