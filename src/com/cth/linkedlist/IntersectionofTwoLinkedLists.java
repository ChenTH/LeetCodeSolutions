package com.cth.linkedlist;

public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int acount = 0;
        int bcount = 0;
        ListNode lsa = headA;
        ListNode lsb = headB;
        while (lsa != null) {
            lsa = lsa.next;
            acount++;
        }
        while (lsb != null) {
            lsb = lsb.next;
            bcount++;
        }
        lsa = headA;
        lsb = headB;
        if (bcount > acount) {
            lsa = headB;
            lsb = headA;
            acount = acount + bcount;
            bcount = acount - bcount;
            acount = acount - bcount;
        }//acount和headA为长的链，bcount和headB为短的链
        for (int i = 0; i < acount - bcount; i++) {
            lsa = lsa.next;
        }
        while (lsa != lsb) {
            lsa = lsa.next;
            lsb = lsb.next;
        }
        return lsa;
    }
}
