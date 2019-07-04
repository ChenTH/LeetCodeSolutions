package com.cth.interview.oj.NetEase170812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by SherlockTHao on 2017/8/12.
 * С�׽�n�����Ӱڷ���һ�����޴�������ϡ���i�����ӷ��ڵ�x[i]��y[i]�С�ͬһ������������ö�����ӡ�ÿһ�β���С�׿��԰�һ���������𲢽����ƶ���ԭ���ӵ��ϡ��¡����ҵ�����һ�������С�С����֪��Ҫ�������ϳ�����һ��������������i(1 �� i �� n)����������Ҫ�����ٲ�������.
 * <p>
 * ��������:
 * �����������,��һ��һ������n(1 �� n �� 50),��ʾ���ӵĸ���
 * �ڶ���Ϊn�����ӵĺ�����x[i](1 �� x[i] �� 10^9)
 * ������Ϊn�����ӵ�������y[i](1 �� y[i] �� 10^9)
 * <p>
 * <p>
 * �������:
 * ���n������,��i����ʾ��������һ������������i����������Ҫ�Ĳ�����,�Կո�ָ��ĩ�޿ո�
 * <p>
 * ��������ʾ:
 * ����1������: ����Ҫ����
 * ����2������: ��ǰ�������ӷ���(1, 1)��
 * ����3������: ��ǰ�������ӷ���(2, 1)��
 * ����4������: ���������Ӷ�����(3, 1)��
 * <p>
 * ��������1:
 * 4
 * 1 2 4 9
 * 1 1 1 1
 * <p>
 * �������1:
 * 0 1 3 10
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] axisX = new int[count];
        int[] axisY = new int[count];
        for (int i = 0; i < count; i++) {
            axisX[i] = in.nextInt();
        }
        for (int j = 0; j < count; j++) {
            axisY[j] = in.nextInt();
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    int[] res2 = new int[count];
                    for (int l = 0; l < count; l++) {
                        res2[j] = Math.abs(axisX[l] - axisX[j]) + Math.abs(axisX[l] - axisX[j]);
                    }
                    Arrays.sort(res2);
                    int res3 = 0;
                    for (int l = 0; l < count; l++) {
                        res3 += res2[l];
                    }
                    res[i] = res[i] > res3 ? res[i] : res3;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.print(res[i]);
            } else {
                System.out.print(" " + res[i]);
            }
        }
    }
}
