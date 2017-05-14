package com.cth.test;

import java.util.Collections;
import java.util.LinkedList;

public class sloution3 {
    
    public static void allPermutation(int n,int k){
        //保存所有的全排列
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
        	nums[i]=i+1;
        }
        LinkedList<String> listStr = new LinkedList<String>();
        allPermutation(nums, listStr, 0,k,n-k-1);
        
        print(listStr);//打印全排列
    }
    
    
    private static void allPermutation(int[] c, LinkedList<String> listStr, int start,int k,int l){

        
        if(start == c.length-1){
        	StringBuffer sBuffer=new StringBuffer();
        	for(int i:c){
        		sBuffer.append(i);
        	}
        	listStr.add(sBuffer.toString());
        }
        else{
            for(int i = start; i <= c.length-1; i++)
            {
            	if(c[i]>c[start]){
            		if(k<=0){
            			continue;
            		}
            		else {
                		k--;
					}
            	}
            	else {
            		if(l<=0){
            			continue;
            		}
            		else {
                		l--;
					}
				}
                swap(c, i, start);//相当于: 固定第 i 个字符
                allPermutation(c, listStr, start+1,k,l);//求出这种情形下的所有排列
                swap(c, start, i);//复位
            	if(c[i]>c[start]){
            		k++;
            	}
            	else {
            		l++;
				}
            }
        }
    }
    
    private static void swap(int[] c, int i, int j){
        int tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
    
    private static void print(LinkedList<String> listStr)
    {
        Collections.sort(listStr);//使字符串按照'字典顺序'输出
        for (String str : listStr) {
            System.out.println(str);
        }
        System.out.println("size:" + listStr.size());
    }
    
    //hapjin test
    public static void main(String[] args) {
        allPermutation(3,1);
    }
}

