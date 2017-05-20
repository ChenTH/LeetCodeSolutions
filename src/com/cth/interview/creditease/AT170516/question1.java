package com.cth.interview.creditease.AT170516;

/**
 * Created by SherlockTHao on 2017/5/18.
 * 给出一个字符串A：aacabbbkekk
 *                aa abbbk kk
 * 给出一个字符串B：abk
 * 重复串概念：B1：abk B2：aabbkk B3：aaabbbkkk
 * 找出最长的重复串是A的一个子序列
 */
public class question1 {
    public static void main(String[] args){
        int i=getLongestRepeatStrLength("aacaabbbbkekkabk","abk");
        System.out.print(i);
    }
    public static int getLongestRepeatStrLength(String s,String t){
        if(s==null || t==null) return 0;
        int high=s.length()/t.length(),low=0,res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(comp(s,t,mid)){
                low=mid+1;
                res=mid;
            }
            else {
                high=mid-1;
            }
        }
        return res;
    }
    public static boolean comp(String s,String t,int n){
        int i=0,j=0,count=n;
        while (i<s.length()&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                count--;
                if(count==0){
                    j++;
                    if(j==t.length()) break;
                    count=n;
                }
            }
            i++;
        }
        if(t.length()==j) return true;
        else    return false;
    }
}
