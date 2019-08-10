package com.cth.backup.hashtable.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FractiontoRecurringDecimal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = -2147483648;
        int b = 1;
        System.out.println(fractionToDecimal(a, b));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        String symbol = "";
        if (numerator < 0 ^ denominator < 0) {
            symbol = "-";
        }
        long unsignumerator = Math.abs((long) numerator);
        long unsigdenominator = Math.abs((long) denominator);
        long interger = unsignumerator / unsigdenominator;
        long beforePoint = interger;
        long remainder = unsignumerator % unsigdenominator;
        if (remainder == 0) {
            if (beforePoint != 0) {
                return symbol + "" + beforePoint + "";
            } else {
                return beforePoint + "";
            }
        }
        Set<Long> set = new HashSet<Long>();
        Map<Long, Integer> map = new HashMap<>();
        set.add((long) 0);
        List<Long> list = new ArrayList<>();
        int end = 0;
        while (true) {
            if (!set.add(remainder)) {
                break;
            }
            map.put(remainder, end);
            end++;
            remainder *= 10;
            interger = remainder / unsigdenominator;
            remainder = remainder % unsigdenominator;
            list.add(interger);
        }
        int bef = end;
        if (remainder != 0) {
            bef = map.get(remainder);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < list.size(); j++) {
            if (j == bef && remainder != 0) {
                stringBuffer.append("(");
            }
            stringBuffer.append(list.get(j));
        }
        if (remainder != 0) {
            stringBuffer.append(")");
        }
        return symbol + "" + beforePoint + "." + stringBuffer.toString();
    }
}
