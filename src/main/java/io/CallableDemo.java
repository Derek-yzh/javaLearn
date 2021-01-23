package io;

import java.util.concurrent.*;

/**
 * @Author: Derek
 * @DateTime: 2021/1/21 15:17
 * @Description: TODO
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> submit = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("test Callable");
                return 2;

            }
        });
        Object o = submit.get();
        System.out.println(o);
        executor.shutdown();
    }

}
