package designPatterns;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 18:41
 * @Description: 模板方法 钩子函数
 */
public class TemplateMethod {

    public static void main(String[] args) {
        F f = new C();
        f.m();
    }

}
abstract class F{
    void m(){
        op1();
        op2();
    }
    protected abstract void op1();
    protected abstract void op2();
}
class C extends F{

    @Override
    protected void op1() {
        System.out.println("op1");
    }

    @Override
    protected void op2() {
        System.out.println("op2");
    }
}
