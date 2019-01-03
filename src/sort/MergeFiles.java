package sort;

import java.io.*;
import java.util.ArrayList;

/**
 * 合并文件
 *
 * @author APP
 */
public class MergeFiles {
    public static ArrayList<File> fileList = new ArrayList<>();
    private static SmallHeap heap = new SmallHeap(101);

    /**
     * 创建文件并写入内容
     * @param dic
     */
    public static void create(String dic) {
        File file = new File(dic);
        if (file.isDirectory()) {
            String fileName = dic + "\\test";
            for (int i = 0; i < 100; i++) {
                File f = new File(fileName + i);
                if (!f.exists()) {
                    try {
                        f.createNewFile();
                        writeFileContent(f.getAbsolutePath(), i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void writeFileContent(String fileName, long i) {
        File file = new File(fileName);
        if (file.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file))) {
                for (int j = 0; j < 100; j++) {
                    i = i + j;
                    pw.write(i + "\r\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件
     *
     * @param file
     */

    public static void read(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    read(f);
                }
            }
        } else {
            fileList.add(file);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        create("H:\\data\\mergeFileData");
        for (File file : fileList) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String word = br.readLine();
                heap.insert(word);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
