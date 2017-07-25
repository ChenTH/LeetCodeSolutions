package com.cth.interview.oj.cow0725;

import java.util.Scanner;

/**
 * Created by SherlockTHao on 2017/7/25.
 */
public class problem3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        int[] res={0};
        gengStr(sb,res,n);
        System.out.print(res[0]-1);
    }
    public static void gengStr(StringBuilder sb,int[] res,int tar){
        if(judge(sb)){
            if(sb.length()==tar){
                System.out.println(sb.toString());
                res[0]++;
                return ;
            }
            gengStr(sb.append('Y'),res,tar);
            sb.delete(sb.length()-1,sb.length());
            gengStr(sb.append('N'),res,tar);
            sb.delete(sb.length()-1,sb.length());
        }
    }
    public static boolean judge(StringBuilder sb){
        if(sb.length()==1) return true;
        char[] chars=sb.toString().toCharArray();
        for(int i=0;i<sb.length();i++){
            if(chars[i]!='A' && chars[i]=='N'){
                for(int j=2*i+1;j<sb.length();j+=i+1){
                    if(chars[j]=='Y'){
                        return false;
                    }
                    else {
                        chars[j]='A';
                    }
                }

            }
        }
        return true;
    }
}
