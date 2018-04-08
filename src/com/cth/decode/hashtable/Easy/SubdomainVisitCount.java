package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static void main(String[] args){
        String[] test={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(test));
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] str1 = s.split(" ");
            int count = Integer.parseInt(str1[0]);
            String[] str2 = str1[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = str2.length - 1; i >= 0; i--) {
                sb.insert(0, str2[i]);
                int value = map.getOrDefault(sb.toString(), 0);
                value += count;
                map.put(sb.toString(), value);
                sb.insert(0, ".");
            }
        }
        List<String> result = new ArrayList<>();
        for(String key:map.keySet()){
            result.add(map.get(key)+" "+key);
        }
        return result;
    }
}
