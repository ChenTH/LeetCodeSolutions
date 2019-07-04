package com.cth.decode.hashtable.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsv {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortStr = new String(ch);
            List<String> strlist = new ArrayList<>();
            if (map.containsKey(sortStr)) {
                strlist = map.get(sortStr);
            }
            strlist.add(str);
            map.put(sortStr, strlist);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
