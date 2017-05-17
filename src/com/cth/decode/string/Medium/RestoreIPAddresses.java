package com.cth.decode.string.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SherlockTHao on 2017/5/16.
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        String str = "25525511135";
        System.out.print(restoreIpAddresses(str));
    }

    public static List<String> restoreIpAddresses(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if(i+1>s.length()) break;
            if(s.charAt(0)=='0' && i>0) break;
            if (s.length() - i - 1 < 3) break;
            if (Integer.valueOf(s.substring(0, i + 1)) > 255) break;
            for (int j = 0; j < 3; j++) {
                if(j+1 > s.length() - i - 1) break;
                if(s.charAt(i+1)=='0'&&j>0) break;
                if (s.length() - i - j - 2 < 2) break;
                if (Integer.valueOf(s.substring(i + 1, i + j + 2)) > 255) break;
                for (int k = 0; k < 3; k++) {
                    if(k+1> s.length() - i - j - 2) break;
                    if(s.charAt(i+j+2)=='0' && k>0) break;
                    if (s.length() - i - j - k - 3 < 1) break;
                    if (Integer.valueOf(s.substring(i + j + 2, i + j + k + 3)) > 255) break;

                    if(s.charAt(i+j+k+3)=='0' && s.length() - i - j - k - 3>1) continue;
                    if (s.length() - i - j - k - 3 > 3) continue;
                    if (Integer.valueOf(s.substring(i + j + k + 3)) > 255) continue;

                    String res = s.substring(0, i + 1) + "." + s.substring(i + 1, i + j + 2) + "." + s.substring(i + j + 2, i + j + k + 3) + "." + s.substring(i + j + k + 3);
                    set.add(res);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
