package com.cth.linkedlist;

public class DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
    public void deleteNode(ListNode node) {
    	if(node==null){
	return ;
}
node.val=node.next.val;
node.next=node.next.next;
    }
    public class ListNode {
    	     int val;
    	      ListNode next;
    	      ListNode(int x) { val = x; }
    	  }

}
