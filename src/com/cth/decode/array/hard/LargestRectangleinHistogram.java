package com.cth.decode.array.hard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by SherlockTHao on 2017/8/6.
 */
public class LargestRectangleinHistogram {
    public static int largestRectangleArea2(int[] heights) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            set.add(heights[i]);
        }
        int res = 0;
        Iterator<Integer> iter=set.iterator();
        while (iter.hasNext()){
            int i=iter.next();
            int count = 0, maxCount = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= i) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
            if (maxCount * i > res) {
                res = maxCount * i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.print(largestRectangleArea2(new int[]{1, 0, 1, 0, 1}));
    }
}
