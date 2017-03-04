package com.cth.decode.math;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="      -11919730356x";
		int b=myAtoi(string);
		System.out.println(b);
	}
    public static int myAtoi(String str) {
    	int result=0;
    	int post=0;
    	int sign=1;
    	boolean flag=true;
    	for(int i=0;i<str.length();i++){
    		char a=str.charAt(i);
    		if(!(a==' '&&result==0&&post==0&&flag)){//是否空格，是否计算过数字，是否计算过符号位
    			if((a=='+'||a=='-')&&result==0){//符号位
    				if(flag){
        				if(a=='+'){
        					sign=1;
        				}
        				else {
        					sign=-1;
						}
        				flag=false;//防止符号位重复
    				}
    				else {
						break;
					}

    			}
    			else if((a-48)>9||(a-48)<0){//是否非数字
    				break;
    			}
    			else {//如果是数字
    				if(post<=9){//如果位数小于等于9
    	    		if(result>0 && post==9){//判断是否溢出
    		    		if(2147483647/10<result ||(2147483647/10==result && (a-48)%10>7)){
    		    			return 2147483647;
    		    		}
    	    		}
    	    		else if(result<0 && post==9){
    	        		if(-2147483647/10>result ||(-2147483647/10==result && (a-48)%10>8)){
    	        			return -2147483648;
    	        		}	
    				}
					result=result*10+(a-48)*(sign);
					post++;
    			}
    				else {//如果位数大于9
						if(result>0){
							return 2147483647;
						}
						else {
							return -2147483648;
						}
					}
    				}
    		}
    	}
		return result;
    }
}
