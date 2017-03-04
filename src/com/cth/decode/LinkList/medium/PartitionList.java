package com.cth.decode.LinkList.medium;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
		node1.next=node2;
		node2.next=null;
		partition(node1,0);
	}
    public static ListNode partition(ListNode head, int x) {
    	ListNode lowbeg=null;
    	ListNode lowend=null;
    	ListNode heighbeg=null;
    	ListNode heighEnd=null;
    	while (head!=null) {
    		if(head.val<x){
    			if(lowbeg==null){
    				lowbeg=head;
    				lowend=head;
    			}
    			else {
					lowend.next=head;
					lowend=head;
				}
    		}
    		else {
    			if(heighbeg==null){
    				heighbeg=head;
    				heighEnd=head;
    			}
    			else {
    				heighEnd.next=head;
    				heighEnd=head;
				}
			}
			head=head.next;
		}
    	if(heighEnd!=null){
        	heighEnd.next=null;
    	}
    	if(lowend!=null){
    		lowend.next=heighbeg;
    		return lowbeg;
    	}
    	else {
			return heighbeg;
		}
    }
}
