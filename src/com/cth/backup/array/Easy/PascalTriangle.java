package com.cth.backup.array.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> result = generate(5);

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> rows1 = new ArrayList<Integer>();
        rows1.add(1);
        result.add(rows1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows2 = new ArrayList<Integer>();
            rows2.add(1);
            for (int j = 1; j < rows1.size(); j++) {
                rows2.add(rows1.get(j - 1) + rows1.get(j));
            }
            rows2.add(1);
            result.add(rows2);
            rows1 = rows2;
        }
        return result;

    }

}
