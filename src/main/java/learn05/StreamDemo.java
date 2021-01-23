package learn05;

import java.io.*;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 9:06
 * @Description: TODO
 */
public class StreamDemo {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("src/abc.txt");
        int read = 0;
        while ((read = inputStream.read()) != -1)   System.out.println((char) read);
        inputStream.close();

        OutputStream outputStream = new FileOutputStream("src/abc.txt",true); //true:追加写
        outputStream.write(99);
        outputStream.write("\r\ntest".getBytes()); //  \r\n ：换行
        outputStream.close();

    }


}
