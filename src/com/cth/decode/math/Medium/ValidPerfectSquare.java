package com.cth.decode.math.Medium;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPerfectSquare(int num) {//平方数是1+3+5+7+9+....
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
