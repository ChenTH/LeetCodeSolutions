package com.cth.backup.math.Easy;

public class NthDigit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 49;
        System.out.println(findNthDigit2(2147483647));
    }

    public static int findNthDigit(int n) {
        int num = 1;
        int base = 1;
        int count = 0;
        while (num < 10) {
            int tmp = count + 9 * num * base;
            if (tmp > n) {
                break;
            }
            count = tmp;
            num++;
            base *= 10;
        }
        int remain = n - count;
        int index1 = remain / num;
        int index2 = remain % num;
        if (index2 == 0) {
            return (base + index1 - 1) % 10;
        } else {
            int result = base + index1;
            for (int i = 1; i < index2; i++) {
                result %= base;
                base /= 10;
            }
            return result / base;
        }
    }

    public static int findNthDigit2(int n) {
        int num = 1;
        long base = 9;
        int remain = n;
        while (remain > num * base) {
            remain = (int) (remain - num * base);
            num++;
            base *= 10;
        }
        int index1 = (remain - 1) / num;
        int index2 = (remain - 1) % num;
        int num1 = (int) (Math.pow(10, num) + index1);
        return Character.getNumericValue(Integer.toString(num1).charAt(index2));
    }

    public static int findNthDigit3(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
