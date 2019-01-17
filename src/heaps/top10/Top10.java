package heaps.top10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Top10 {
	private static File[] files = new File[10];
	private static int count = 100000;

	private static String path = "D:/top10/";

	public static void init() throws IOException {
		initBigFile();
		init10File();
	}

	public static void initBigFile() throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		File bigFile = new File(path + "bigFile.txt");
		if (!bigFile.exists()) {
			bigFile.createNewFile();
		} else {
			try (FileWriter fileWriter = new FileWriter(bigFile)) {
				fileWriter.write("");
				fileWriter.flush();
			}
		}
		// 写入内容
		writeContent(bigFile);
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
			File tmpfile = new File(path + "file" + i + ".txt");
			if (!tmpfile.exists()) {
				tmpfile.createNewFile();
			} else {
				try (FileWriter fileWriter = new FileWriter(tmpfile)) {
					fileWriter.write("");
					fileWriter.flush();
				}
			}
		}
	}

	public static void top10(File file) {
//		for(int )
	}

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		init();
		long end = System.currentTimeMillis();
		System.out.println("spend time:" + (end - start) / 1000 + "s");
	}
}
