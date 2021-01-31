package designPatterns;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 13:24
 * @Description: 观察者 （事件模型）
 *
 * 事件模型 Observer Listener Hook Callback  都是观察者模式
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Child child = new Child();

        child.wakeUp();
    }

}

interface Event<T>{
    T getSource();
}

//事件类
@Data
class WakeUpEvent implements Event<Child>{
    long timestamp;
    String location;
    Child source;

    public WakeUpEvent(long timestamp, String location, Child source) {
        this.timestamp = timestamp;
        this.location = location;
        this.source = source;
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("Dad: " + event);
        System.out.println("Dad: feeding...");
    }
}
class Mum implements Observer{
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("Mum: " + event);
        System.out.println("Mum: hugging...");
    }
}

class Child{

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    private boolean cry = false;
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        System.out.println("Wake up ！Crying...");
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bad",this);

        for (Observer observer : observers)
            observer.actionOnWakeUp(event);

    }


}