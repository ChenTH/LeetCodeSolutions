package com.cth.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Mainbolantree {

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
    	Stack<Integer> stack=new Stack<>();
    	String [] arr = expr.split("\\s+");
    	for(int i=0;i<arr.length;i++){
    		if("*".equals(arr[i])) {
    			if(stack.size()>=2){
    				int a=stack.pop();
    				int b=stack.pop();
    				stack.push(a*b);
    			}
    			else {
					return -1;
				}
			}
    		else if("+".equals(arr[i])){
    			if(stack.size()>=2){
    				int a=stack.pop();
    				int b=stack.pop();
    				stack.push(a+b);
    			}
    			else {
					return -1;
				}
			}
    		else if("^".equals(arr[i])){
    			if(stack.size()>=1){
    				int a=stack.pop();
    				stack.push(++a);
    			}
    			else {
					return -1;
				}
			}
    		else {
				if (stack.size() >= 16) {
					return -2;
				} else {
					stack.push(Integer.parseInt(arr[i]));
				}
			}
    	}
		return stack.pop();
    }
    public static int count(String s){
        String[]str=s.split(" ");
        Stack<Integer>stack=new Stack<>();
        for (String temp:str){
            if (temp.equals("^")){
                if (stack.size()<1){
                    return -1;
                }else {
                    int num=stack.pop();
                    num++;
                    stack.push(num);
                }
            }else if (temp.equals("+")){
                if (stack.size()<2)
                    return -1;
                else {
                    int add1=stack.pop();
                    int add2=stack.pop();
                    int sum=add1+add2;
                    stack.push(sum);
                }
            }else if (temp.equals("*")){
                if (stack.size()<2){
                    return -1;
                }else {
                    int mul1=stack.pop();
                    int mul2=stack.pop();
                    stack.push(mul1*mul2);
                }
            }
            else if (temp.equals("")){
                continue;
            }else  {
                if (stack.size()>=16)
                    return -2;
                else {
                    stack.push(Integer.valueOf(temp));
                }
            }
        }
        return stack.pop();
    }
}