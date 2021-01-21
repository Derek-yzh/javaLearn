package learn02;

import java.util.ArrayList;

/**
 * @Author: Derek
 * @DateTime: 2021/1/19 20:27
 * @Description: TODO
 */
@SuppressWarnings("All")
public class _003_IntegerDemo{

    public static void main(String[] args) {
        int a = 10;
        Integer a2 = new Integer(10);
        System.out.println(a == a2);
        System.out.println("-------------------");

        Integer a3 = Integer.valueOf(a); //装箱
        int a4 = a2.intValue(); //拆箱
        System.out.println(a2 == a3);
        System.out.println(a == a4);
        System.out.println("-------------------");
    }

}
