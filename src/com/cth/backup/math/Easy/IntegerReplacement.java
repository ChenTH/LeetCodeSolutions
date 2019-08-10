package com.cth.backup.math.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class IntegerReplacement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(integerReplacement(65535));
    }

    public static int integerReplacement(int n) {
        if (Integer.MAX_VALUE == n) {
            return 32;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int count = 0;
        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                System.out.print(tmp + "  ");
                if (tmp == 1) {
                    return count;
                }
                if (tmp % 2 == 0) {
                    queue.offer(tmp / 2);
                } else {
                    queue.offer(tmp + 1);
                    queue.offer(tmp - 1);
                }
            }
            System.out.println();
            count++;
        }
    }

    public static int integerReplacement2(int n) {
        return n;
    }
}
