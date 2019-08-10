package com.cth.backup.string.Easy;

public class LengthofLastWord {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String aString = "a";
        System.out.println(lengthOfLastWord(aString));
    }

    public static int lengthOfLastWord(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        ;
        char[] arr = s.toCharArray();
        int end = length - 1;
        while (end > -1 && arr[end] == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int flag = end;
        while (flag >= 0 && arr[flag] != ' ') {
            flag--;
        }
        return end - flag;
    }
}
