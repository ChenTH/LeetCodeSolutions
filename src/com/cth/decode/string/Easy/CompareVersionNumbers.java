package com.cth.decode.string.Easy;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String string1 = "1.2.10";
        String string2 = "1.2";
        System.out.println(compareVersion(string1, string2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length1 = v1.length;
        int length2 = v2.length;
        for (int i = 0; i < length1 || i < length2; i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < length1) {
                num1 = Integer.parseInt(v1[i]);
            }
            if (i < length2) {
                num2 = Integer.parseInt(v2[i]);
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
