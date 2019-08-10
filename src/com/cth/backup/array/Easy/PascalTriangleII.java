package com.cth.backup.array.Easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> result = getRow2(18);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            System.out.print("  ");
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        int count = rowIndex / 2 + rowIndex % 2 - 1;
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                result.add(1);
            } else if (i <= count) {
                BigInteger a = BigInteger.valueOf(1);
                for (int j = rowIndex - 1; j >= rowIndex - i; j--) {
                    a = a.multiply(BigInteger.valueOf(j));
                }
                for (int j = 1; j <= i; j++) {
                    a = a.divide(BigInteger.valueOf(j));

                }
                result.add(Integer.parseInt(a.toString()));
            } else {
                result.add(result.get(rowIndex - 1 - i));
            }
        }
        return result;
    }

    public static List<Integer> getRow2(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> rows1 = new ArrayList<Integer>();
        if (rowIndex == 0) {
            return rows1;
        }
        rows1.add(1);
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> rows2 = new ArrayList<Integer>();
            rows2.add(1);
            for (int j = 1; j < rows1.size(); j++) {
                rows2.add(rows1.get(j - 1) + rows1.get(j));
            }
            rows2.add(1);
            rows1 = rows2;
        }
        return rows1;
    }

}
