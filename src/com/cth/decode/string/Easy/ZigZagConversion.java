package com.cth.decode.string.Easy;

public class ZigZagConversion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "PAYPALISHIRING";
        System.out.println(convert(a, 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        ;
        char[] ss = new char[s.length()];
        int length = s.length();
        int index = 0;
        int row = 1;
        int increment1 = 0;
        int increment2 = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int n = i;
            while (n < length) {
                if (increment1 != 0 && increment2 != 0) {
                    ss[index] = s.charAt(n);
                    n = n + increment2;
                    index++;
                    if (n < length && index < length) {
                        ss[index] = s.charAt(n);
                        n = n + increment1;
                        index++;
                    }
                } else if (increment1 != 0) {
                    ss[index] = s.charAt(n);
                    n = n + increment1;
                    index++;
                } else {
                    ss[index] = s.charAt(n);
                    n = n + increment2;
                    index++;
                }
            }
            increment1 = increment1 + 2;
            increment2 = increment2 - 2;
        }
        return new String(ss);
    }
}
