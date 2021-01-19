package learn02;

import java.lang.reflect.Method;

/**
 * @Author: Derek
 * @DateTime: 2021/1/18 22:15
 * @Description: TODO
 */
public class _001_Class {

    int i = 10;

    static public void test(){
        System.out.println("test");
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) throws Exception {
        _001_Class test = new _001_Class();
        Class<? extends _001_Class> clazz = test.getClass();
        Method getI = clazz.getMethod("getI");

        Object o = new Object();
        if (test instanceof _001_Class) System.out.println("11");
        else System.out.println("22");

        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a：" + a + "\tb：" + b);

    }

}
