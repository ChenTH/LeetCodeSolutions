package com.cth.interview.huawei;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SherlockTHao on 2017/8/16.
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new LinkedList<String>();
        while (in.hasNext()) {
            String str = in.nextLine();
            list.add(str);
            if (!str.endsWith(",")) {
                break;
            }
        }
        Set<String> set = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        String regex = "0x[A-Fa-f0-9]+";
        Pattern p = Pattern.compile(regex);
        for (String str : list) {
            Matcher m = p.matcher(str);
            String ModuleId = null, DependModuleId = null;
            if (m.find()) {
                ModuleId = m.group();
            }
            if (m.find()) {
                DependModuleId = m.group();
            }
            if (ModuleId != null && DependModuleId != null) {
                set.add(ModuleId);
                set.add(DependModuleId);
                AddDependency(ModuleId, DependModuleId, map);
            }
        }
        for (String key : set) {
            System.out.println("{" + key + ", " + MouldeIsCycularDependency(key, map) + "},");
        }
    }

    public static void AddDependency(String ModuleId, String DependModuleId, Map<String, Set<String>> map) {
        Set<String> set = map.getOrDefault(ModuleId, new HashSet<String>());
        set.add(DependModuleId);
        map.put(ModuleId, set);
    }

    public static boolean MouldeIsCycularDependency(String ModuleId, Map<String, Set<String>> map) {
        Set<String> set = new HashSet<String>();
        mergeSet(set, map.getOrDefault(ModuleId, new HashSet<String>()));
        Set<String> used = new HashSet<>();
        while (set.size() != 0 && !set.contains(ModuleId)) {
            Set<String> setCopy = new HashSet<>();
            mergeSet(setCopy, set);
            Iterator<String> itr = setCopy.iterator();
            while (itr.hasNext()) {
                String str = itr.next();
                if (!used.contains(str)) {
                    used.add(str);
                    mergeSet(set, map.getOrDefault(str, new HashSet<String>()));
                }
                set.remove(str);
            }
        }
        if (set.size() == 0) {
            return false;
        }
        if (set.contains(ModuleId)) {
            return true;
        }
        return true;
    }

    public static void mergeSet(Set<String> set1, Set<String> set2) {
        Iterator<String> itr = set2.iterator();
        while (itr.hasNext()) {
            set1.add(itr.next());
        }
    }

}
