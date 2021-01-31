package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 18:44
 * @Description: 状态模式
 */

public class StateDemo {

    public static void main(String[] args) {
        M m = new M();
        m.state = new HappyState();
        m.smile();
    }
}

abstract class State {
    abstract void smile();
    abstract void cry();
    abstract void say();
}
class M{
    String name;
    State state;
    public void smile(){
        state.smile();
    }
    public void cry(){
        state.cry();
    }
    public void say(){
        state.say();
    }
}
class HappyState extends State{

    @Override
    void smile() {
        System.out.println("happy smile");
    }

    @Override
    void cry() {
        System.out.println("happy cry");
    }

    @Override
    void say() {
        System.out.println("happy say");
    }
}
class SadState extends State{

    @Override
    void smile() {
        System.out.println("sad smile");
    }

    @Override
    void cry() {
        System.out.println("sad cry");
    }

    @Override
    void say() {
        System.out.println("sad say");
    }
}