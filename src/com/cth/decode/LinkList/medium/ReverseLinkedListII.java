package com.cth.decode.LinkList.medium;

import java.util.List;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode node1=new ListNode(1);
//		ListNode node2=new ListNode(2);
//		ListNode node3=new ListNode(3);
//		ListNode node4=new ListNode(4);
//		ListNode node5=new ListNode(5);
//		node1.next=node2;
//		node2.next=node3;
//		node3.next=node4;
//		node4.next=node5;
//		node5.next=null;
//		reverseBetween(node1,2,4);
		ListNode node1=new ListNode(3);
		ListNode node2=new ListNode(5);
		node1.next=node2;
		node2.next=null;
		reverseBetween(node1,1,2);
	}
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m==n){
    		return head;
    	}
    	ListNode fakeHead=new ListNode(0);
    	fakeHead.next=head;
    	ListNode bef=fakeHead,end=fakeHead;
    	int i=1;
    	while (i<m) {
    		bef=bef.next;
    		i++;
		}
    	ListNode revBeg=bef.next;
    	ListNode node=bef.next;
    	ListNode next=node.next;
    	while (i<n-1) {
    		ListNode temp=next.next;
    		next.next=node;
    		node=next;
    		next=temp;
    		i++;
		}
    	end=next.next;
    	next.next=node;
    	bef.next=next;
    	revBeg.next=end;
		return head;
    }
}
