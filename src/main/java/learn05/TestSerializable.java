package learn05;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 12:01
 * @Description: TODO
 */
/**
 * 1、如果需要将对象通过io流进行传输，那么必须要实现序列化接口
 * 2、当前类中必须声明一个serialVersionUID的值，值为多少无所谓，但是要有
 * 3、transient:使用此关键字修饰的变量，在进行序列化的时候，不会别序列化
 */
@Data
public class TestSerializable implements Serializable {

    long serialVersionUID = 1L;

    private int id;
    private String name;
}
