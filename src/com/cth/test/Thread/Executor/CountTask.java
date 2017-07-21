package com.cth.test.Thread.Executor;

/**
 * Created by SherlockTHao on 2017/5/26.
 */
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


        public class CountTask extends RecursiveTask<Long>{

            private static final int THRESHOLD = 10000;
            private long start;
            private long end;

            public CountTask(long start, long end) {
                super();
                this.start = start;
                this.end = end;
            }

            @Override
            protected Long compute() {
                System.out.println(Thread.currentThread().getId()+" "+start+" "+end);
                long sum = 0;
                boolean canCompute = (end - start) < THRESHOLD;
                if(canCompute)
                {
                    for (long i = start; i <= end; i++) {
                        sum = sum + i;
                    }
                }else
                {
                    //分成100个小任务
                    long step = (start + end)/100;
                    ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
                    long pos = start;
                    for (int i = 0; i < 100; i++) {
                        long lastOne = pos + step;
                        if(lastOne > end )
                        {
                            lastOne = end;
                        }
                        CountTask subTask = new CountTask(pos, lastOne);
                        pos += step + 1;
                        subTasks.add(subTask);
                        subTask.fork();//把子任务推向线程池
                    }
                    for (CountTask t : subTasks) {
                        sum += t.join();//等待所有子任务结束
                    }
                }
                return sum;
            }

            public static void main(String[] args) {
                ForkJoinPool forkJoinPool = new ForkJoinPool();
                CountTask task = new CountTask(0, 200000L);
                ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum = " + res);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}