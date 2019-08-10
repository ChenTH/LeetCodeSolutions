package com.cth.backup.LinkList.hard;

public class MergekSortedLists {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode[] lists = new ListNode[2];
        ListNode node1 = new ListNode(1);
        lists[0] = node1;
        ListNode node2 = new ListNode(0);
        lists[1] = node2;
        mergeKLists(lists);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode node = fakeHead;
        boolean flag = true;
        while (flag) {
            int i = -1;
            flag = false;
            ListNode lNode = null;
            for (int j = 0; j < lists.length; j++) {
                if (lists[j] != null) {
                    flag = true;
                    if (i == -1) {
                        lNode = lists[j];
                        i = j;
                    } else {
                        if (lists[j].val < lNode.val) {
                            lNode = lists[j];
                            i = j;
                        }
                    }
                }
            }
            if (flag) {
                node.next = lNode;
                node = lNode;
                lists[i] = lNode.next;
            }
        }
        return fakeHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return pattern(lists, 0, lists.length - 1);
    }

    public ListNode pattern(ListNode[] lists, int b, int e) {
        if (b == e) return lists[b];
        if (b < e) {
            int m = (b + e) / 2;
            ListNode l1 = pattern(lists, b, m);
            ListNode l2 = pattern(lists, m + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode fakeNode = new ListNode(0);
        ListNode node = fakeNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return fakeNode.next;
    }
}
