package io;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 15:43
 * @Description: end-start: 3500
 */
public class _01_TestWithoutNetty {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            try { TimeUnit.MILLISECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(doSomething(finalI));
        }
        long end = System.currentTimeMillis();
        System.out.println("-------"+ (end - start) +"-------");

    }

    private static int doSomething(int i) {
        try { TimeUnit.MILLISECONDS.sleep(30);} catch (InterruptedException e) {e.printStackTrace();}
        return i << 2;
    }

}
