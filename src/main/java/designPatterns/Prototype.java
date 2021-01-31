package designPatterns;

import lombok.Data;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 17:55
 * @Description: 原型 浅拷贝 深拷贝 浅克隆 深克隆
 */
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Per per = new Per();
        Per clone = (Per)per.clone();
        System.out.println(per.id + "--" + clone.id);
        System.out.println(per.name + "--" + clone.name);
        System.out.println(per.location + "--" + clone.location);
        System.out.println(per == clone);
        per.location.no = 100;
        System.out.println(clone.location.no);
        System.out.println("=====================================");

        Per2 per2 = new Per2();
        Per2 clone2 = (Per2)per2.clone();
        System.out.println(per2.id + "--" + clone2.id);
        System.out.println(per2.name + "--" + clone2.name);
        System.out.println(per2.location + "--" + clone2.location);
        System.out.println(per2 == clone2);
        per2.location.no = 100;
        System.out.println(clone2.location.no);
    }

}
@Data
class Per implements Cloneable{
    int id = 8;
    String name = "a";
    Location location = new Location();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
@Data
class Location{
    int no = 8;
}

@Data
class Per2 implements Cloneable{
    int id = 8;
    String name = "a";
    Location2 location = new Location2();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Per2 clone = (Per2) super.clone();
        clone.location = (Location2) location.clone();
        return clone;
    }
}
@Data
class Location2 implements Cloneable{
    int no = 8;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}