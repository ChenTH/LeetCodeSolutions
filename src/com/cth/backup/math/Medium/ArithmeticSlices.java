package com.cth.backup.math.Medium;

public class ArithmeticSlices {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int result = 0;
        int index = 0;
        while (index < A.length - 1) {
            int range = A[index + 1] - A[index];
            int count = 2;
            index = index + 2;
            while (index < A.length && A[index] - A[index - 1] == range) {
                count++;
                index++;
            }
            if (count > 2) {
                result += (count - 2) * (count - 1) / 2;
            }
            index--;
        }
        return result;
    }
}
