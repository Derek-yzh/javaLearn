package designPatterns;

import com.google.common.reflect.AbstractInvocationHandler;
import lombok.Data;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 14:56
 * @Description: 代理
 */
public class ProxyDemo {

    public static void main(String[] args) {
        //静态代理
        //Movable proxy = new TankLogProxy(new TankTimeProxy(new Tank()));
        //proxy.move();

        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");//可以生成代理类源码
        Tank tank = new Tank();
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method: " + method.getName() + " start...");
                Object o = method.invoke(tank, args);
                System.out.println("method: " + method.getName() + " end...");
                return o;
            }
        });
        m.move();

        cglib();
    }

    //JDK1.8 cglib代理 不需要实现接口
    static void cglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                Object res = null;
                res = methodProxy.invoke(o,objects);
                System.out.println("after");
                return res;
            }
        });
    }

}

interface Movable{
    void move();
}

@Data
class TankLogProxy implements Movable{
    private Movable tank;

    public TankLogProxy(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("log start...");
        tank.move();
        System.out.println("log end...");
    }
}

@Data
class TankTimeProxy implements Movable{
    private Movable tank;

    public TankTimeProxy(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("moving");
        try { TimeUnit.MILLISECONDS.sleep(new Random().nextInt(4000));} catch (InterruptedException e) {e.printStackTrace();}
    }
}

