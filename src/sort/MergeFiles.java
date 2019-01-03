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

<<<<<<< HEAD
	}

	public static void main(String[] args) {
		for(File file:fileList) {
//			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		}
	}
=======
    public static void main(String[] args) throws FileNotFoundException {
        for (File file : fileList) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            heap.insert()
        }
    }
>>>>>>> 88753ee0cf60c2a3e0e95e00d824f5fd32c984f7
}
