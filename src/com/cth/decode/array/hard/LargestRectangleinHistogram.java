package com.cth.decode.array.hard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Created by SherlockTHao on 2017/8/6.
 */
public class LargestRectangleinHistogram {
    //TLE�㷨
    public static int largestRectangleArea(int[] heights) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < heights.length; i++) {
            set.add(heights[i]);
        }
        int res = 0;
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
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

    //discuess���㷨
    public static int largestRectangleArea2(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    //��ʹ��collection��ʹ��������� ��ʡʱ��
    public int largestRectangleArea3(int[] h) {
        int n = h.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int is = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : h[i];
            while (is != -1 && height < h[stack[is]]) {
                int hh = h[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.print(largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
