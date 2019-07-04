package com.cth.decode.string.Easy;

public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverseWord(word) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverseWord(String word) {
        StringBuilder sb = new StringBuilder();
        char[] cs = word.toCharArray();
        for (char c : cs) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
