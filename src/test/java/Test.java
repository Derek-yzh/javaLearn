import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableCallable;
import co.paralleluniverse.strands.SuspendableRunnable;
import io.netty.channel.nio.NioEventLoopGroup;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2021/1/21 16:03
 * @Description: TODO
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() throws ExecutionException, InterruptedException {

        Fiber<Object> f = new Fiber<>(new SuspendableCallable<Object>() {
            @Override
            public Object run() throws SuspendExecution, InterruptedException {
                return 1;
            }
        });

        f.start();
        System.out.println(f.get());

    }

    @org.junit.jupiter.api.Test
    public void printStream() throws IOException {
        PrintStream out = System.out;
        out.write("aaaa".getBytes());

        System.err.println("error");
    }

    @org.junit.jupiter.api.Test
    public void netty() throws IOException {
        NioEventLoopGroup group = new NioEventLoopGroup(2);
        System.out.println(System.currentTimeMillis());
        group.next().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("---");
                System.out.println(System.currentTimeMillis());
            }
        },3, TimeUnit.SECONDS);
        //group.shutdownGracefully();
        System.in.read();
    }

}
