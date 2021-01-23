package lerrn07_Internet.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 21:38
 * @Description: TODO
 */
public class Client2 {
    public static void main(String[] args) throws IOException {

        //创建客户端的套接字
        Socket client = new Socket("127.0.0.1",10000);
        //--------------------向外进行输出---------------
        //获取输出流对象
        OutputStream outputStream = client.getOutputStream();
        //数据输出
        outputStream.write("hello java".getBytes());

        //--------------------接受服务端返回的消息---------------------------
        //获取输出流对象
        InputStream inputStream = client.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("服务端的响应数据是：" + new String(buf,0,length));

        //关闭流操作
        inputStream.close();
        outputStream.close();
        client.close();
    }
}
