package com.cth.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode reverseList(ListNode head) {
    	ListNode ls1=null;
    	ListNode ls2=null;
    	while(head!=null){
    		ls1=head;
    		head=head.next;
    		ls1.next=ls2;
    		ls2=ls1;
    	}
		return ls1;
    }
    public class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	  }
}
