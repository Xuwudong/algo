package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 合并文件
 *
 * @author APP
 */
public class MergeFiles {
	public static ArrayList<File> fileList = new ArrayList<>();
	private static SmallHeap heap = new SmallHeap(101);
	private static HashMap<File, Integer> fileReaded = new HashMap<>();

	// 空文件个数
	private static int emptyFiles = 0;

	/**
	 * 创建文件并写入内容
	 *
	 * @param dic
	 */
	public static void create(String dic) {
		File file = new File(dic);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (file.isDirectory()) {
			String fileName = dic + "\\test";
			for (int i = 0; i < 100; i++) {
				File f = new File(fileName + i + ".txt");
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
					i = i + 100;
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
				} else {
					fileList.add(f);
					fileReaded.put(f, 0);
				}
			}
		} else {
			fileList.add(file);
			fileReaded.put(file, 0);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
//		create("E:\\data\\mergeFileData");
		File dir = new File("E:\\data\\mergeFileData");
		read(dir);
		File bigFile = new File("E:\\data\\mergeFileData\\bigFile.txt");
		if (!bigFile.exists()) {
			try {
				bigFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			bigFile.delete();
			try {
				bigFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(bigFile))) {
			for (File file : fileList) {
				try (RandomAccessFile raf = new RandomAccessFile(file.getAbsolutePath(), "rw")) {
					raf.seek(fileReaded.get(file));
					String word = raf.readLine();
					if (word != null) {
						fileReaded.put(file, fileReaded.get(file) + word.length() * 2);
						heap.insert(word);
						String minWord = heap.deleteFirst();
						pw.write(minWord + "\r\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//		for (Map.Entry<File, Integer> entry : fileReaded.entrySet()) {
//			System.out.println(entry.getKey().getName() + "\t" + entry.getValue());
//		}
		
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(bigFile))) {
			for (File file : fileList) {
				try (RandomAccessFile raf = new RandomAccessFile(file.getAbsolutePath(), "rw")) {
					raf.seek(fileReaded.get(file));
					String word = raf.readLine();
					System.out.println(word);
					if (word != null) {
						fileReaded.put(file, fileReaded.get(file) + word.length() * 2);
						heap.insert(word);
						String minWord = heap.deleteFirst();
						pw.write(minWord + "\r\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
//		for (Map.Entry<File, Integer> entry : fileReaded.entrySet()) {
//			System.out.println(entry.getKey().getName() + "\t" + entry.getValue());
//		}

//		
//		try (PrintWriter pw = new PrintWriter(new FileOutputStream(bigFile))) {
//			while (emptyFiles < 100) {
//				for (File file : fileList) {
//					try (RandomAccessFile raf = new RandomAccessFile(file.getAbsolutePath(), "rw")) {
//						raf.seek(fileReaded.get(file));
//						String word = raf.readLine();
//						if (word != null) {
//							fileReaded.put(file, fileReaded.get(file) + word.length() * 2);
//							heap.insert(word);
//							String minWord = heap.deleteFirst();
//							
//							while (minWord.equals(word)) {
//								System.out.println(minWord);
//								pw.write(minWord + "\r\n");
//								fileReaded.put(file, fileReaded.get(file) + word.length() * 2);
//								raf.seek(fileReaded.get(file));
//								word = raf.readLine();
//								if (word != null) {
//									fileReaded.put(file, fileReaded.get(file) + word.length() * 2);
//									heap.insert(word);
//									minWord = heap.deleteFirst();
//								}else {
//									emptyFiles++;
//									break;
//								}
//							}
//
//						} else {
//							emptyFiles++;
//						}
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		heap.print();
	}
}
