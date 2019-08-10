package com.cth.backup.LinkList.medium;

import java.util.HashMap;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode node = fakeHead;
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (node.next != null) {
            int val = node.next.val;
            if (map.containsKey(val)) {
                node.next = node.next.next;
                if (map.get(val) != null) {
                    ListNode node2 = map.get(val);
                    node2.next = node2.next.next;
                    map.put(val, null);
                }
            } else {
                ListNode next = node.next;
                while (next.next != null && next.next.val == node.next.val) {
                    next = next.next;
                }
                if (next.next == null) {
                    if (next != node.next) {
                        node.next = null;
                    }
                    break;
                } else if (next == node.next) {
                    map.put(val, node);
                    node = node.next;
                } else {
                    node.next = next.next;
                    map.put(val, null);
                }

            }
        }
        return fakeHead.next;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode node = fakeHead;
        while (node.next != null) {
            ListNode next = node.next;
            while (next.next != null && next.next.val == node.next.val) {
                next = next.next;
            }
            if (next.next == null) {
                if (next != node.next) {
                    node.next = null;
                }
                break;
            } else if (next == node.next) {
                node = node.next;
            } else {
                node.next = next.next;
            }
        }
        return fakeHead.next;
    }
}
