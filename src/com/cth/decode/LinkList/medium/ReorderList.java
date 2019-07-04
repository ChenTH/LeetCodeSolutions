package com.cth.decode.LinkList.medium;

import com.cth.decode.LinkList.medium.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        com.cth.decode.LinkList.medium.ListNode node1 = new ListNode(1);
        com.cth.decode.LinkList.medium.ListNode node2 = new ListNode(2);
        com.cth.decode.LinkList.medium.ListNode node3 = new ListNode(3);
//		com.cth.decode.LinkList.medium.ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
//		node4.next=null;
        reorderList(node1);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode endNode = head;
        int count = 1;
        while (endNode.next != null) {
            endNode = endNode.next;
            count++;
        }
        if (count <= 2) {
            return;
        }
        int mid = count / 2;
        ListNode midNode = head;
        for (int i = 0; i < mid - 1; i++) {
            midNode = midNode.next;
        }
        ListNode node = midNode;
        midNode = midNode.next;
        node.next = null;
        ListNode temp = midNode.next;
        midNode.next = null;
        while (temp != null) {
            ListNode a = temp.next;
            temp.next = midNode;
            midNode = temp;
            temp = a;
        }
        temp = head;
        ListNode bef = null;
        while (temp != null && endNode != null) {
            ListNode a = endNode.next;
            ListNode b = temp.next;
            endNode.next = temp.next;
            temp.next = endNode;
            bef = endNode;
            temp = b;
            endNode = a;
        }
        if (endNode != null) {
            bef.next = endNode;
        }
    }
}
