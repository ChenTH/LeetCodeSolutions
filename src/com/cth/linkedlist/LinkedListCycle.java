package com.cth.linkedlist;

import java.util.HashSet;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean hasCycle(ListNode head) {
    	HashSet<ListNode> set=new HashSet<ListNode>();
    	while(head!=null){
    		if(set.contains(head)){
    			return true;
    		}
    		else {
        		set.add(head);	
			}
    		head=head.next;
    	}
		return false;
    }
}
