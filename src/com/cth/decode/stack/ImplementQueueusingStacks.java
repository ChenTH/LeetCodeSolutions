package com.cth.decode.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementQueueusingStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue2 queue=new MyQueue2();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
	}

}
class MyQueue {
    // Push element x to the back of queue.
	Stack<Integer> stack1=new Stack<>();//进队列
	Stack<Integer> stack2=new Stack<>();//出队列
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty()){
        	while (!(stack1.isEmpty())) {
				stack2.push(stack1.pop());
			}
        	stack2.pop();
        }
        else {
			stack2.pop();
		}
    }

    // Get the front element.
    public int peek() {
        if(stack2.isEmpty()){
        	while (!(stack1.isEmpty())) {
				stack2.push(stack1.pop());
			}
        	return stack2.lastElement();
        }
        else {
        	return stack2.lastElement();
		}
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	if(stack1.isEmpty()&&stack2.isEmpty()){
    		return true;
    	}
    	else {
			return false;
		}
    }
}
class MyQueue2 {
    // Push element x to the back of queue.
    Queue<Integer> queue = new LinkedList<Integer>();
    public void push(int x) {
       queue.offer(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.poll();
    }

    // Get the front element.
    public int peek() {
    	return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return queue.isEmpty();
    }
}