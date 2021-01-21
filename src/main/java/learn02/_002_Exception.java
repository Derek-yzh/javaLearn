package learn02;

/**
 * @Author: Derek
 * @DateTime: 2021/1/18 22:41
 * @Description: TODO
 */
public class _002_Exception {

    public static void main(String[] args) {
        System.out.println("test:"+test()+"\n");
        System.out.println("test:"+test2().num);
    }

    private static int test() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        }catch (Exception e){
            System.out.println("error");
        }finally {
            if (num > 20) System.out.println("num>20");
            System.out.println("finally");
            num = 1;
        }
        return num;
    }

    static class Num{
        int num;
    }

    private static Num test2() {
        Num num = new Num();
        try {
            System.out.println("try");
            num.num += 80;
            return num;
        }catch (Exception e){
            System.out.println("error");
        }finally {
            System.out.println("finally");
            num.num = 1;
        }
        return num;
    }

}
