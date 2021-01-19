package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/18 23:24
 * @Description: 单例模式
 */
public class Singleton {

    private static volatile Singleton instance;

    public static Singleton get() {
        if (instance == null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        int name = 1;
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(_Singleton.INSTANCE.getInstance());
            }).start();
        }
    }

}

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 */
enum _Singleton{
    INSTANCE;
    private Singleton instance;
    _Singleton(){
        instance = new Singleton();
    }
    public Singleton getInstance(){
        return instance;
    }
}