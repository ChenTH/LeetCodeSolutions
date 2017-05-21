package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
/**
 * Created by SherlockTHao on 2017/5/21.
 */
public class MergeIntervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public static void main(String[] args){
        List<Interval> list=new ArrayList<>();
        //[1,3],[2,6],[8,10],[15,18]
        list.add(new Interval(1,2));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        List<Interval> res=merge(list);
        for(int i=0;i<res.size();i++){
            System.out.print("["+res.get(i).start+","+res.get(i).end+"]");
        }

    }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start<b.start){
                    return -1;
                }
                else if(a.start==b.start){
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0) return intervals;
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
         for(int i=1;i<intervals.size();i++){
             Interval iel=intervals.get(i);
             if(iel.start<=end){
                 end=Integer.max(end,iel.end);
             }
             else {
                 res.add(new Interval(start,end));
                 start=iel.start;
                 end=iel.end;
             }
         }
         res.add(new Interval(start,end));
         return res;
    }
}
