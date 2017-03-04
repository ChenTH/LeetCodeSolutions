package com.cth.decode.LinkList.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode detectCycle(ListNode head) {
    	Set<ListNode> set=new HashSet<>();
    	ListNode node=head;
    	while (node != null && set.add(node)) {
    		node=node.next;
		}
		return node;
    }
    public ListNode detectCycle3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow){
                ListNode slow2 = head; 
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
