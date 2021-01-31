package designPatterns;

import lombok.Data;

import java.io.*;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 18:12
 * @Description: 备忘录 记录过程 快照
 */
public class Memento {

    public static void main(String[] args) throws Exception {
        A a = new A(1, "b");
        save(a);
        load();
    }

    public static void save(Object o) throws Exception {
        File file = new File("Memento.data");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(o);
    }
    public static void load() throws Exception {
        File file = new File("Memento.data");
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
        A a = (A) oos.readObject();
        System.out.println(a);
    }
}
@Data
class A implements Serializable{
    private int id = 0;
    private String name = "a";

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }
}