package com.cth.decode.LinkList.hard;

import com.cth.decode.LinkList.hard.ListNode;

public class ReverseNodesinkGroup {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//		ListNode node3=new ListNode(3);
//		ListNode node4=new ListNode(4);
//		ListNode node5=new ListNode(5);
        node1.next = node2;
        node2.next = null;
//		node3.next=node4;
//		node4.next=node5;
//		node5.next=null;
        reverseKGroup(node1, 3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode fakeNode = new ListNode(0);
        ListNode groupHead = fakeNode;
        ListNode node1 = head;
        int i = 1;
        ListNode nextGroupHead = node1;
        while (node1 != null) {
            if (i % k == 1) {
                nextGroupHead = node1;
            }
            ListNode temp = node1.next;
            node1.next = groupHead.next;
            groupHead.next = node1;
            node1 = temp;
            if (i % k == 0) {
                groupHead = nextGroupHead;
            }
            i++;
        }
        if (i % k != 1) {
            node1 = groupHead.next;
            while (node1 != null) {
                ListNode temp = node1.next;
                node1.next = groupHead.next;
                groupHead.next = node1;
                node1 = temp;
            }
        }
        return fakeNode.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
