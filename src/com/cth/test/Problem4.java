package com.cth.test;

import java.util.Stack;
class parenthesis {
	char parenthesis;
	int index;
}
public class Problem4 {
	
    public static void main(String[] args) {  
		// TODO Auto-generated method stub
		String a="()))";
		char[] b=a.toCharArray();
		Stack<parenthesis> stack=new Stack<parenthesis>();
		for(int i=0;i<b.length;i++){
			parenthesis pt=new parenthesis();
			pt.parenthesis=b[i];
			pt.index=i;
			if(pt.parenthesis==')'){
				if(stack.size()>0){
					if(stack.firstElement().parenthesis=='('){
						stack.pop();
					}
					else{
						stack.push(pt);
					}
				}
				else{
					stack.push(pt);
				}
			}
			else{
				stack.push(pt);
			}
		}
		int count=stack.size();
		int diff=getDiff(stack);
		int left=getLeftCount(stack,0,diff);
		int right=getRightCount(stack,diff,stack.size());
		int res=0;
		if(left==0){
			res=right;
		}
		else if(right==0){
			res=left;
		}
		else{
			res=left*right;
		}
		System.out.println(res);
	}
    public static int getDiff(Stack<parenthesis> stack){
    	if(stack.size()>0){
        	if(stack.get(0).parenthesis=='('){
        		return 0;
        	}
        	else if(stack.get(stack.size()-1).parenthesis==')'){
        		return stack.size();
        	}
        	else{
        		for(int i=0;i<stack.size();i++){
        			if(stack.get(i).parenthesis=='('){
        				return i;
        			}
        		}
        	}
    	}
    	else{
    		return 0;
    	}
		return 0;
    }
    public static int getLeftCount(Stack<parenthesis> stack,int beg,int end){
    	if(stack.get(beg).parenthesis==0){
        	return (end-beg-1)*2+1;
    	}
    	else{
        	return (end-beg)*2;
    	}
    }
    public static int getRightCount(Stack<parenthesis> stack,int beg,int end){
    	if(stack.get(end-1).parenthesis==stack.size()){
        	return (end-beg-1)*2+1;
    	}
    	else{
    		return (end-beg)*2;
    	}
    }
}
