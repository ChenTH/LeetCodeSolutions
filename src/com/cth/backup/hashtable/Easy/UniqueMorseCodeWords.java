package com.cth.backup.hashtable.Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        String[] strings = {"rwjje", "aittjje", "auyyn", "lqtktn", "lmjwn"};
        System.out.println(uniqueMorseRepresentations(strings));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String fullTable = ".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..";
        String[] codes = fullTable.split(",");
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                sb.append(codes[c - 'a']);
            }
            System.out.println(sb.toString());
            set.add(sb.toString());
        }
        return set.size();
    }
}
