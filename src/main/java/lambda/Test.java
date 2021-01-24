package lambda;

import java.util.ArrayList;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 23:55
 * @Description: 策略者模式
 */
/**
 * 函数式接口:
 *   Consumer<T>消费型接口
 *    对类型为T的对象应用操作,包含方法:void accept(T t);
 *   Supplier<T>供给型接口
 *     返回类型为T的对象,包含方法::T get();
 *   Function<T, R>函数型接口
 *     对类型为T的对象应用操作,并返回结果.结果是R类型的对象包含方法: R apply(T t);
 *   Predicate<T>断定型接口
 *     确定类型为T的对象是否满足某约束，并返回boolean值。包含方法boolean test(T t);
 *
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        doFilter(list, student -> student.getAge() > 14 && student.getScore() > 75);
        System.out.println(list);
    }

    public static void doFilter(ArrayList<Student> students, StudentFilter filter){
        students.removeIf(student -> !filter.compare(student));
    }

}
