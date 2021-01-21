package learn03;

/**
 * @Author: Derek
 * @DateTime: 2021/1/20 20:00
 * @Description: TODO
 */
public enum  _003_Enum {

    LAUNCH("launch"),PAGEVIEW("pageview"),EVENT("event");

    _003_Enum(String name){
        this.name = name;
    }

    private String name;

    public void show(){
        System.out.println(name);
        _003_Enum[] ee = values();
        for (_003_Enum e : ee) {
            System.out.println(e);
        }
    }

}
