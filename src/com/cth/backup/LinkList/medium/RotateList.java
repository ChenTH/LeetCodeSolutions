package com.cth.backup.LinkList.medium;

public class RotateList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode bef = head, las = head;
        int len = 0;
        while (bef != null) {
            bef = bef.next;
            len++;
        }
        bef = head;
        int realK = k % len;
        for (int i = 0; i < realK; i++) {
            bef = bef.next;
        }
        while (bef.next != null) {
            bef = bef.next;
            las = las.next;
        }
        bef.next = head;
        head = las.next;
        las.next = null;
        return head;
    }
}
