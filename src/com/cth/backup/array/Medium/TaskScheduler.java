package com.cth.backup.array.Medium;

/**
 * Created by SherlockTHao on 2017/8/3.
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        int max = 0;
        for (char c : tasks) {
            charCount[c - 'A']++;
        }
        for (int i : charCount) {
            if (i > max) {
                max = i;
            }
        }
        int maxCount = 0;
        for (int i : charCount) {
            if (i == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {
        leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
