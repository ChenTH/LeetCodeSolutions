package com.cth.backup.string.Easy;

public class CountandSay {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String countAndSay(int n) {
        String a = "1";
        for (int i = 1; i < n; i++) {
            a = getSequence(a);
        }
        return a;
    }

    public String getSequence(String s) {
        StringBuilder ss = new StringBuilder();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(index) != s.charAt(i)) {
                int count = i - index;
                ss.append(count);
                ss.append(s.charAt(index));
                index = i;
            }
        }
        int count = length - index;
        ss.append(count);
        ss.append(s.charAt(length - 1));
        return ss.toString();
    }
}
