package designPatterns;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 10:46
 * @Description: 工厂模式
 */
public class Factory {

    private static ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();

    static {
        map.put("car",new Car());
    }

    public static Object getInstance(String name){
        return map.getOrDefault(name, null);
    }

    public static void main(String[] args) {
        Moveable m = (Moveable) Factory.getInstance("car");
        m.go();
    }

}

class Car implements Moveable{
    @Override
    public void go(){
        System.out.println("car going ...");
    }
}

interface Moveable{
    void go();
}
