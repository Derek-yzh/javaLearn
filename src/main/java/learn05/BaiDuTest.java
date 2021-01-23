package learn05;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 13:51
 * @Description: TODO
 */
public class BaiDuTest {

    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), StandardCharsets.UTF_8));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("BaiDu.html")));

            String msg = null;
            while((msg = bufferedReader.readLine())!=null){
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
