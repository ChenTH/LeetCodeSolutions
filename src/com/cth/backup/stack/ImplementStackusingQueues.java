package com.cth.backup.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack.empty());
    }

}

class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x);
            while (!(queue2.isEmpty())) {
                queue1.offer(queue2.poll());
            }
        } else {
            queue2.offer(x);
            while (!(queue1.isEmpty())) {
                queue2.offer(queue1.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.isEmpty()) {
            queue2.poll();
        } else {
            queue1.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}