package com.cth.backup.LinkList.medium;

public class ConvertSortedListtoBinarySearchTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        sortedListToBST(node1);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    public static TreeNode toBST(ListNode head, ListNode end) {
        if (head == end) return null;
        ListNode fast = head, slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, end);
        return node;
    }

    public static TreeNode toBST2(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            node.left = toBST2(head);
            node.right = toBST2(slow.next);
        } else {
            node.left = null;
            node.right = null;
        }
        return node;
    }
}
