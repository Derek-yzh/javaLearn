package io;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 14:45
 * @Description: ens-start: 432
 */
public class _01_TestNetty {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            try { TimeUnit.MILLISECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            netty.execute(() -> doSomething(finalI));
        }
        long end = System.currentTimeMillis();
        System.out.println("-------"+ (end - start) +"-------");

    }

    private static void doSomething(int i) {
        Future<Object> submit = netty.next().submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try { TimeUnit.MILLISECONDS.sleep(30);} catch (InterruptedException e) {e.printStackTrace();}
                return i << 1;
            }
        });
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static NioEventLoopGroup netty = new NioEventLoopGroup(20);

}
