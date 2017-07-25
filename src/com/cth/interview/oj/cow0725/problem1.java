package com.cth.interview.oj.cow0725;
import java.util.Scanner;
/**
 * Created by SherlockTHao on 2017/7/25.
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i=2;i<str.length();i+=2){
            if(judgeStr(str.substring(0,str.length()-i))){
                System.out.print(str.length()-i);
                break;
            }
        }
    }
    public static boolean judgeStr(String str){
        String str1=str.substring(0,str.length()/2);
        String str2=str.substring(str.length()/2,str.length());
        if(str1.equals(str2)){
            return  true;
        }
        else {
            return false;
        }
    }
}
