package com.java8.test3.stream;

import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Long> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoin(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoin left = new ForkJoin(start, middle);
            left.fork();  //������΄գ�ͬ�rѹ���̶߳���

            ForkJoin right = new ForkJoin(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }

    }

}
