package com.cth.decode.LinkList.medium;

import java.util.Stack;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        node23.next = null;
        addTwoNumbers(node1, node21);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode node = l1;
        while (node != null) {
            stack1.push(node);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            stack2.push(node);
            node = node.next;
        }
        int temp = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int l1val = 0, l2val = 0;
            if (!stack1.isEmpty()) {
                l1val = stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                l2val = stack2.pop().val;
            }
            int a = l1val + l2val + temp;
            temp = a / 10;
            node = head;
            head = new ListNode(a % 10);
            head.next = node;
        }
        if (temp != 0) {
            node = head;
            head = new ListNode(temp);
            head.next = node;
        }
        return head;
    }
}
