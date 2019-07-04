package com.cth.interview.creditease.AT170516;

import java.util.*;

/**
 * Created by SherlockTHao on 2017/5/18.
 * 存在一个链表ABCDEFJ....XYZ...但不给出
 * 给出一个List<Node>，其中元素为链表中项 BFACEY
 * 找出list中存在的链表中的串 ABC EF Y
 */
public class question2 {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        List<Node> list = new LinkedList<>();
        list.add(node3);
        list.add(node5);
        list.add(node2);
        getSeqFromList(list);
    }

    public static void getSeqFromList(List<Node> list) {
        HashSet<Node> set = new HashSet<>();
        for (Node n : list) {
            set.add(n);
        }
        HashSet<Node> headSet = new HashSet<>();
        Iterator<Node> itr = set.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            if (headSet.contains(node.next)) {
                headSet.remove(node.next);
            }
            headSet.add(node);
        }
        itr = headSet.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            while (set.contains(node)) {
                System.out.print(node.val);
                node = node.next;
            }
        }
    }
}
