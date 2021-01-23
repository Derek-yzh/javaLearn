package lerrn07_Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 21:38
 * @Description: TODO
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        InetAddress my = InetAddress.getByName("ahuaa");
        System.out.println(localHost);
        System.out.println(my);

        InetAddress inetAdd = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAdd);
        System.out.println(inetAdd.getHostAddress());
        System.out.println(inetAdd.getHostName());
    }
}