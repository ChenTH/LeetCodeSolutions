package com.cth.decode.math.Easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by SherlockTHao on 2017/6/7.
 */
public class PerfectNumber {
    public static void main(String args[]){
        System.out.print(checkPerfectNumber(28));
    }
    public static boolean checkPerfectNumber(int num) {
        if(num<=1) return false;
        Set<Integer> set=new HashSet<>();
        set.add(1);
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                if(set.contains(i)){
                    break;
                }
                else {
                    set.add(i);
                    set.add(num/i);
                }
            }
        }
        int res=0;
         Iterator<Integer> itr=set.iterator();
         while(itr.hasNext()){
             res+=itr.next();
         }
        if(res==num) return true;
        else return false;
    }
}
