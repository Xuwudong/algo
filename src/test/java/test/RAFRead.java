package test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFRead {
    private static int len = 0;

    public static void main(String[] args) throws Exception {
        while (true) {
            try (RandomAccessFile raf = new RandomAccessFile("H:\\data\\mergeFileData\\test0.txt", "r")) {
                try {
                    raf.seek(len);
                    String word = raf.readLine();
                    if (word != null && word != "\r\n") {
                        System.out.println(word);
                        len = len + word.length() + 2;
                    } else {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
