package com.cth.interview.alibaba;

/**
 * Created by SherlockTHao on 2017/8/25.
 */

import java.lang.reflect.Array;
import java.util.Scanner;

public class problem1 {
/** ������������process������ʵ����ĿҪ��Ĺ��� **/
    /**
     * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^
     **/
    static class boxTemplate {
        public static int price;
        public static int length;
        public static int width;
        public static int height;
    }

    static class Model {
        public int price;
        public int length;
        public int width;
        public int height;

    }

    private static int process() {
        return 1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = 2000;
        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
//            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());

        }
    }

}