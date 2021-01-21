package learn03;

/**
 * @Author: Derek
 * @DateTime: 2021/1/20 19:57
 * @Description: TODO
 */
public class _002_Math {

    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
        System.out.println(Math.sqrt(5.0)); //开方
        System.out.println(Math.pow(2, 3)); //2的3次方
        System.out.println(Math.ceil(3.14)); //向上取整
        System.out.println(Math.floor(3.14)); //向下取整

        _003_Enum launch = _003_Enum.LAUNCH;
        launch.show();
    }

}
