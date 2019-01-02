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

    public static void init() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        for (File file : fileList) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            heap.insert()
        }
    }
}
