package com.cth.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class maptest {
    public static void mian(String[] args) {
        Hashtable<Integer, Integer> tHashtable = new Hashtable<>();
        ConcurrentHashMap<Integer, Integer> cmap = new ConcurrentHashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new Vector<>();
    }
}
