package com.cth.test.Thread.Lock;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTryLockTest implements Runnable
{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run()
    {
        try
        {
            if (lock.tryLock(5, TimeUnit.SECONDS))
            {
                System.out.println(Thread.currentThread().getName()+"取得锁");
                Thread.sleep(6000);
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+"get lock failed");
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            if (lock.isHeldByCurrentThread())
            {
                System.out.println(Thread.currentThread().getName()+"释放锁");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args)
    {
        ReentrantLockTryLockTest t = new ReentrantLockTryLockTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
    }

}
