package com.cth.decode.math.Easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        selfDividingNumbers(1, 1000);

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean flag = true;
            while (temp != 0) {
                int a = temp % 10;
                if (a != 0) {
                    int b = i % a;
                    if (b != 0) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
                temp = temp / 10;
            }
            if (flag) {
                System.out.println(i);
                result.add(i);
            }
        }
        return result;
    }
}
