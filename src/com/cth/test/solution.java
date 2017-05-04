package com.cth.test;
import java.util.Scanner;
/**
 * Created by SherlockTHao on 2017/3/23.
 */
public class solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int result=0;
            char[] a=new char[n];
            for(int i=0;i<n;i++){
                a[i]='A';
            }

            System.out.println();
        }
        public static boolean addOne(char[] a){
            int i=a.length-1;
            int pre=0;
            while (i>=0){
                if(pre==0){
                    if(a[i]!='Z'){
                        a[i]+=1;
                    }
                    else {
                        pre=1;
                        a[i]='A';
                    }
                }
                else {
                    if(a[i]!='Z'){
                        a[i]+=1;
                        break;
                    }
                    else {
                        pre=1;
                        a[i]='A';
                    }
                }
            }
            if(pre==1 && i<0){
                return false;
            }
            else {
                return true;
            }
        }
    }
