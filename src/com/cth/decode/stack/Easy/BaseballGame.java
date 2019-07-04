package com.cth.decode.stack.Easy;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        calPoints(ops);
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "+":
                    stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }
}
