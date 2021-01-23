package io;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

/**
 * @Author: Derek
 * @DateTime: 2021/1/21 15:42
 * @Description: 纤程测试
 */
public class TestFiber {


    public static void main(String[] args) {

        Runnable r = () -> calc();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            Fiber<Void> fiber = new Fiber<>((SuspendableRunnable) () -> calc());
            fiber.start();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            Thread thread = new Thread(r);
            thread.start();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    private static void calc() {
        int result = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 200; j++) {
                result += i;
            }
        }
    }



}
