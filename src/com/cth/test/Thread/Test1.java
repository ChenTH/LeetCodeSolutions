package com.cth.test.Thread;

/**
 * Created by SherlockTHao on 2017/5/26.
 */

public class Test1 extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("我还活着");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Test1();
        t.start();
        Thread.sleep(5000);
        System.out.println("Main End");
    }
}
