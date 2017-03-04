package com.cth.decode.LinkList.hard;

import java.util.HashMap;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public RandomListNode copyRandomList(RandomListNode head) {
    	HashMap<RandomListNode, RandomListNode> map=new HashMap<>();
    	RandomListNode fakeHead=new RandomListNode(0);
    	RandomListNode node2=fakeHead;
    	RandomListNode node=head;
    	while (node!=null) {
    		RandomListNode temp=new RandomListNode(node.label);
    		node2.next=temp;
    		node2=temp;
			map.put(node,temp);
			node=node.next;
		}
    	node=head;
    	while (node!=null) {
			map.get(node).random=map.get(node.random);
			node=node.next;
		}
		return fakeHead.next;
    }
}
