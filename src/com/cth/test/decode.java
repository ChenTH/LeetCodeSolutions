package com.cth.test;

/**
 * Created by SherlockTHao on 2017/3/7.
 */
public class decode {
    public static void main(int n, int l) {
        int bef = 1, end = l;
        int sum = (1 + l) * l / 2;
        if (sum > n) {
            System.out.print("No");
            return;
        }
        int resultbef = 1, resultend = l;
        int resultlong = 0;
        while (true) {
            if (bef <= n / l) {
                int templong = end - bef + 1;
                if (sum < n) {
                    end++;
                    sum += end;
                } else if (sum > n) {
                    sum -= bef;
                    bef++;
                } else {
                    if (resultlong == 0) {
                        resultlong = templong;
                    }
                    if (templong >= l && templong <= resultlong) {
                        resultbef = bef;
                        resultend = end;
                        resultlong = templong;
                    }
                    sum -= bef;
                    bef++;
                    end++;
                    sum += end;
                }
            } else {
                break;
            }
        }
        if (sum == n) {
            if (resultlong > 100) {
                System.out.print("No");
            } else {
                StringBuffer strbuff = new StringBuffer();
                for (int j = resultbef; j < resultend; j++) {
                    strbuff.append(j + " ");
                }
                strbuff.append(resultend);
                System.out.print(strbuff.toString());
            }
        } else {
            System.out.print("No");
        }
    }
}
