package com.cth.backup.unclassifiable;

public class NumberofLinesToWriteString {
    public static void main(String[] args) {

    }

    public int[] numberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        int lines = 0;
        int width = 0;
        for (int i = 0; i < chars.length; i++) {
            width += widths[chars[i] - 'a'];
            if (width > 100) {
                lines++;
                i--;
                width = 0;
            }
        }
        int[] result = new int[2];
        result[0] = lines;
        result[1] = width;
        return result;
    }
}
