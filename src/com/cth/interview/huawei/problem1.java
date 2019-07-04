package com.cth.interview.huawei;

/**
 * Created by SherlockTHao on 2017/8/16.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;
        if (in.hasNext()) {
            input = in.nextLine();
        } else {
            System.out.print(-1);
        }
        //������
        String[] vals = input.split("\\s+");
        //ȥ������/0
        String a = vals[0];
        String b = vals[1];
        //����ƥ��
        if (a.length() != b.length()) {
            System.out.print(-1);
            return;
        }
        //������
        if (!isNumeric(a) || !isNumeric(b)) {
            System.out.print(-1);
            return;
        }
        //��������ͬ
        System.out.print(findLongest(a, b));
    }

    public static int findLongest(String A, String B) {
        char[] achars = A.toCharArray();
        char[] bcahrs = B.toCharArray();
        int max = -1;
        int i = 0;
        while (i < A.length()) {
            int tmp = 0;
            while (i < A.length() && achars[i] == bcahrs[i]) {
                i++;
                tmp++;
            }
            if (tmp > max) {
                max = tmp;
            }
            i++;
        }
        return max;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
