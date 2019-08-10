package com.cth.backup.LinkList.medium;

public class SortList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        sortList(node1);
    }

    public static ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode node = head;
        while (node.next != null) {
            ListNode temp = fakeHead;
            while (temp != node) {
                if (temp.next.val <= node.next.val) {
                    temp = temp.next;
                } else {
                    ListNode temp2 = node.next;
                    node.next = node.next.next;
                    temp2.next = temp.next;
                    temp.next = temp2;
                    break;
                }
            }
            if (temp == node) {
                node = node.next;
            }
        }
        return fakeHead.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return MergeListNode(l1, l2);
    }

    public static ListNode MergeListNode(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode node = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return fakeHead.next;
    }
}
