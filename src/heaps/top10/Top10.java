package heaps.top10;

import java.io.File;

public class Top10 {
	private static File[] files = new File[10];

	private static String path = "D:/top10/";
	public static void init() {

	}

	public static void initBigFile() {
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		
	}

	public static void main() {

	}
}
