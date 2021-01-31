package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 14:44
 * @Description: 享元 (共享元数据 池化)
 */
public class Flyweight {

    public static void main(String[] args) {
        String s1 = new String("a");
        String s2 = "a";

        System.out.println(s1 == s2);
        System.out.println(s1.intern() == s2);//intern()拿到常量池的引用
        System.out.println(s1.intern() == s2.intern());
    }

}
