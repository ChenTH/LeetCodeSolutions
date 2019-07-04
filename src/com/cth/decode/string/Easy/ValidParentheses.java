package com.cth.decode.string.Easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string = "[]";
        System.out.println(isValid(string));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != getMath(a)) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static char getMath(char a) {
        switch (a) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
}
