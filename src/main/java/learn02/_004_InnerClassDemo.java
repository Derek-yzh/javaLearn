package learn02;

/**
 * @Author: Derek
 * @DateTime: 2021/1/19 23:05
 * @Description: 内部类
 *
 */
public class _004_InnerClassDemo {
    int num = 0;
    static int staticNum;
    int test(){
        return num;
    }
    class Inner{
        int id = 0;
        int test(){
            System.out.println(_004_InnerClassDemo.this.test());
            return num; //访问外部类属性
        }
    }
    static class InnerStatic{
        int id = 0;
        int test(){
            return staticNum;
        }
    }

    class Test{
        void test(){
            _004_InnerClassDemo.Inner inner = new _004_InnerClassDemo().new Inner();
            System.out.println(inner.id);
            _004_InnerClassDemo.InnerStatic innerStatic = new _004_InnerClassDemo.InnerStatic();
            System.out.println(innerStatic.test());
        }
        //方法内部类 了解即可
        void t(int a){
            System.out.println("t");
            class Inner{
                private String name;
                public void test(){
                    System.out.println(a);
                    System.out.println(name);
                }
            }
            new Inner().test();
        }
    }
}

