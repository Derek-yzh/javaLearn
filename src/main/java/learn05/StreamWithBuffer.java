package learn05;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 10:56
 * @Description: TODO
 */
public class StreamWithBuffer {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = new FileInputStream("src/abc.txt");
        int length = 0;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1)
            System.out.println(new String(buffer, 0, length));
        /*while ((length = inputStream.read(buffer,3,3)) != -1)
            System.out.println(new String(buffer, 3, length));*/
        inputStream.close();


    }

}
