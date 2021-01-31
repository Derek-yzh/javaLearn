package designPatterns;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @Author: Derek
 * @DateTime: 2021/1/31 17:15
 * @Description: 适配器 转换器
 */
public class Adapter {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("adapter.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !"".equals(line)) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        isr.close();
        fis.close();
    }

}


