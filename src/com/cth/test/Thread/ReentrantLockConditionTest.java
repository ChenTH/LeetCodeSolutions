package com.cth.test.Thread;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionTest implements Runnable
{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run()
    {
        try
        {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ReentrantLockConditionTest t = new ReentrantLockConditionTest();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }

}
