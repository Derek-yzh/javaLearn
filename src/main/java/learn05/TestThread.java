package learn05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 19:45
 * @Description: TODO
 */
public class TestThread {

    public static void main(String[] args) {
        Pcd1 pcd = new Pcd1();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    pcd.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A1").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    pcd.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B1").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    pcd.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A2").start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    pcd.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B2").start();
    }

}
class Pcd1{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment()throws Exception{
        lock.lock();
        try {
            while (number >= 10){
                condition.await();
            }
            try { TimeUnit.MILLISECONDS.sleep(30);} catch (InterruptedException e) {e.printStackTrace();}
            number++;
            System.out.println(Thread.currentThread().getName()+"生产:\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement()throws Exception{
        lock.lock();
        try {
            while (number <= 0){
                condition.await();
            }
            try { TimeUnit.MILLISECONDS.sleep(30);} catch (InterruptedException e) {e.printStackTrace();}
            number--;
            System.out.println(Thread.currentThread().getName()+"消费:\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public synchronized void in()throws Exception{
        //1.判断
        while (number != 0){
            this.wait();
        }
        //2.干活
        number++;
        //3.通知
        System.out.println(Thread.currentThread().getName()+"生产:\t"+number);
        this.notifyAll();
    }
    public synchronized void de()throws Exception{
        while (number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"消费:\t"+number);
        this.notifyAll();
    }
}