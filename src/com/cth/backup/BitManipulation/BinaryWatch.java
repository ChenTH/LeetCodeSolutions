package com.cth.backup.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = readBinaryWatch(2);
//		for (String string : list) {
//			System.out.println(string);
//		}
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        String aString = "";
        if (num == 0) {
            list.add("0:00");
        } else {
            dfs(list, aString, 0, 0, num);
        }
        return list;
    }

    public static void dfs(List<String> list, String bitstrand, int count, int length, int num) {
        if (length > 10) {
            return;
        }
        if (count == num) {
            stringtotime(list, bitstrand, length);
        } else {
            dfs(list, bitstrand + "1", count + 1, length + 1, num);
            dfs(list, bitstrand + "0", count, length + 1, num);
        }
    }

    public static void stringtotime(List<String> list, String bitstrand, int length) {
        int time = Integer.parseInt(bitstrand, 2);
        time = (int) (time * Math.pow(2, 10 - length));
        int hour = (time / 64);
        int minutes;
        if (hour == 0) {
            minutes = time;
        } else {
            minutes = time % (hour * 64);
        }
        if (0 <= hour && hour < 12 && minutes >= 0 && minutes < 60) {
            System.out.print(bitstrand + "   ");
            System.out.print(length + "   ");
            if (minutes < 10) {
                System.out.println(hour + ":" + "0" + minutes);
                list.add(hour + ":" + "0" + minutes);
            } else {
                System.out.println(hour + ":" + minutes);
                list.add(hour + ":" + minutes);
            }
        }
    }

    public List<String> readBinaryWatch2(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++)
            for (int m = 0; m < 60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
