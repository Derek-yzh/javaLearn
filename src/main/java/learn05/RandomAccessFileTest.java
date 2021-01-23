package learn05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @Author: Derek
 * @DateTime: 2021/1/23 14:12
 * @Description: TODO
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("src/abc.txt");
        long length = file.length();
        int blockSize = 8;
        int size = (int) Math.ceil(length*1.0/blockSize);

        System.out.printf("要切成《%d》个块\n",size);

        int beginPos = 0;
        int actualSize = blockSize > length ? (int) length : blockSize;
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size-1) actualSize = (int) length;
            else {
                actualSize = blockSize;
                length -= actualSize;
            }
            System.out.println("------------------------"+beginPos+":"+actualSize);
            function(i,beginPos,actualSize);
        }

    }

    public static void function(int i, int beginPos, int actualSize) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("src/abc.txt"), "r");
        randomAccessFile.seek(beginPos); //表示从哪个偏移量开始读数据
        byte[] bytes = new byte[8];
        int len = 0;
        if ((len = randomAccessFile.read(bytes)) != -1)
            System.out.println(new String(bytes, 0, len));

        randomAccessFile.close();
    }

}
