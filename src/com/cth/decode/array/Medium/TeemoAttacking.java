package com.cth.decode.array.Medium;

/**
 * Created by SherlockTHao on 2017/8/5.
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int gap = 0;
            if (i == timeSeries.length - 1) {
                gap = duration;
            } else {
                gap = timeSeries[i + 1] - timeSeries[i];
            }
            if (gap >= duration) {
                res += duration;
            } else {
                res += gap;
            }
        }
        return res;
    }
}
