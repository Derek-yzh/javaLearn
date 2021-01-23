package lerrn07_Internet.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 21:38
 * @Description: TODO
 */
/*
* 客户端向服务端发送数据
* */
public class Client {
    public static void main(String[] args) throws IOException {

        //创建socket对象，其实是开启实现io的虚拟接口（此接口不是java中的接口，而是类似于网线的插槽）
        //需要指定数据接受方的ip地址和端口号
        Socket client = new Socket("localhost",10086);
        //获取输出流对象，想服务端发送数据
        OutputStream outputStream = client.getOutputStream();
        //将输出流对象进行包装
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //传输数据
        dataOutputStream.writeUTF("hello,你好");
        //关闭流操作
        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
