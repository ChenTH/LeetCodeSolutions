package com.cth.backup.BinarySearch;

public class FirstBadVersion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(firstBadVersion(2));
    }

    public static int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        if (isBadVersion(1)) {
            return 1;
        }
        while (true) {
            int middle = end + (begin - end) / 2;
            if (isBadVersion(middle)) {
                if (!isBadVersion(middle - 1)) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            } else {
                begin = middle + 1;
            }
        }
    }

    public static boolean isBadVersion(int num) {
        int a = 2;
        if (a > num) {
            return false;
        } else {
            return true;
        }

    }
}
