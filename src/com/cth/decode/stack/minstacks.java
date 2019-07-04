package com.cth.decode.stack;

import java.util.Stack;

public class minstacks {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

}

class MinStack {//会有溢出错误
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();
    int min;

    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(0);
        } else {
            if (x < min) {
                stack.push(x - min);
                min = x;
            } else {
                stack.push(x - min);
            }
        }
    }

    public void pop() {
        int a = stack.pop();
        if (a < 0) {
            min = min - a;
        }
    }

    public int top() {
        return min + stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack2 {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack2() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min.push(x);
        } else {
            if (x > min.peek()) {
                stack.push(x);
            } else {
                stack.push(x);
                min.push(x);
            }
        }
    }

    public void pop() {
        int a = stack.pop();
        if (a == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}