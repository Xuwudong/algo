package heaps.top10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Top10 {
    private static File[] files = new File[10];
    private static int count = 1000;
    private static Map<Integer, BufferedWriter> fileReaders = new HashMap<>();

    private static String path = "D:/top10/";

    public static File init() throws IOException {
        File bigFile = initBigFile();
        init10File();
        return bigFile;
    }

    public static File initFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("");
                fileWriter.flush();
            }
        }
        return file;
    }

    public static File initBigFile() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File bigFile = new File(path + "bigFile.txt");
        initFile(bigFile);
        // 写入内容
        writeContent(bigFile);
        return bigFile;
    }

    public static void writeContent(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < i; j++) {
                    writer.write(i + j + "\r\n");
                }
            }
        }
    }

    public static void init10File() throws IOException {
        for (int i = 0; i < 10; i++) {
            File tmpFile = new File(path + "file" + i + ".txt");
            tmpFile = initFile(tmpFile);
            BufferedWriter br = new BufferedWriter(new FileWriter(tmpFile));
            fileReaders.put(i, br);
        }
    }

    public static void top10(File bigFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(bigFile)))) {
            String line = reader.readLine();
            while (line != null && line != "\r\n") {
                int n = Integer.valueOf(line) % 10;
                BufferedWriter br = fileReaders.get(n);
                br.write(line + "\r\n");
                line = reader.readLine();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File bigFile = init();
        top10(bigFile);
        long end = System.currentTimeMillis();
        System.out.println("spend time:" + (end - start) / 1000 + "s");
    }
}
