package heaps.top10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import heaps.Heap;

public class Top10 {
	private static int count = 1000;
	private static Map<Integer, BufferedWriter> fileReaders = new HashMap<>();
	private static Map<Integer, Heap<Word>> fileHeaps = new HashMap<>();

	private static String path = "D:/top10/";

	private static Heap<Word> finalHeap = new Heap<Word>(11, new Comparator<Word>() {
		public int compare(Word o1, Word o2) {
			return o2.getCount() - o1.getCount();
		};
	});

	/**
	 * 初始化
	 * 
	 * @return
	 * @throws IOException
	 */
	public static File init() throws IOException {
		File bigFile = initBigFile();
		init10File();
		return bigFile;
	}

	/**
	 * 创建文件（如果存在，清空内容）
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static File createFile(File file) throws IOException {
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

	/**
	 * 初始化大文件
	 * 
	 * @return
	 * @throws IOException
	 */
	public static File initBigFile() throws IOException {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		File bigFile = new File(path + "bigFile.txt");
		createFile(bigFile);
		// 写入内容
		writeContent(bigFile);
		return bigFile;
	}

	/**
	 * 写入测试内容
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void writeContent(File file) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < count; i++) {
				for (int j = 0; j < i; j++) {
					writer.write(i + j + "\r\n");
				}
			}
		}
	}

	/**
	 * 初始化10个小文件
	 * 
	 * @throws IOException
	 */
	public static void init10File() throws IOException {
		for (int i = 0; i < 10; i++) {
			File tmpFile = new File(path + "file" + i + ".txt");
			tmpFile = createFile(tmpFile);
			// 保存对应文件输出流
			BufferedWriter br = new BufferedWriter(new FileWriter(tmpFile));
			fileReaders.put(i, br);
			// 小顶堆
			Heap<Word> heap = new Heap<>(101, new Comparator<Word>() {
				@Override
				public int compare(Word o1, Word o2) {
					return o2.getCount() - o1.getCount();
				}
			});
			fileHeaps.put(i, heap);
		}
	}

	public static void top10(File bigFile) throws IOException, InterruptedException, ExecutionException {
		try (BufferedReader BigFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(bigFile)))) {
			String line = BigFileReader.readLine();
			// 大文件hash到小文件中
			while (line != null && line != "\r\n") {
				int n = Integer.valueOf(line) % 10;
				BufferedWriter br = fileReaders.get(n);
				br.write(line + "\r\n");
				line = BigFileReader.readLine();
			}
//			ExecutorService executorService = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 10; i++) {
				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(new FileInputStream(new File(path + "file" + i + ".txt"))))) {
					Map<String, Integer> countMap = new HashMap<>();
					String line1 = reader.readLine();
					Heap<Word> heap = null;
					while (line1 != null && line1 != "'\r\n") {
						int count = 1;
						if (countMap.containsKey(line1)) {
							count = countMap.get(line1) + 1;
							countMap.put(line1, count);
						} else {
							countMap.put(line1, 1);
						}
						heap = fileHeaps.get(i);
						// 堆满
						if (heap.getCount() >= 100) {
							Object[] arr = heap.getArr();
							Word minWord = (Word) arr[1];
							if (count > minWord.getCount()) {
								heap.deleteFirst();
								heap.insert(new Word(line1, count));
							}
						} else {
							heap.insert(new Word(line1, count));
						}
						line1 = reader.readLine();
					}
					heap.print();
				}
//				Future<Heap<Word>> future = executorService.submit(new BuildHeapTask(i));
//				Heap<Word> heap = future.get();
			}

			// 合并10个堆
			merge10Heap2FinalHeap();
		}
	}

	public static void merge10Heap2FinalHeap() {
		for (Entry<Integer, Heap<Word>> entry : fileHeaps.entrySet()) {
			Heap<Word> heap = entry.getValue();
//			System.out.println(heap);
			while (heap.getCount() > 0) {
				Word word = heap.deleteFirst();
				System.out.println(word);
				if (finalHeap.getCount() >= 10) {
					Object[] arr = finalHeap.getArr();
					Word firstWord = (Word) arr[1];
					if (word.getCount() > firstWord.getCount()) {
						finalHeap.deleteFirst();
						finalHeap.insert(word);
					}
				} else {
					finalHeap.insert(word);
				}

			}
		}
	}

	/**
	 * 堆取元素
	 * 
	 * @author admin
	 *
	 */
	static class BuildHeapTask implements Callable<Heap<Word>> {

		private int i;

		public BuildHeapTask(int i) {
			this.i = i;
		}

		@Override
		public Heap<Word> call() throws Exception {
			Heap<Word> heap = null;
			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(path + "file" + i + ".txt"))))) {
				Map<String, Integer> countMap = new HashMap<>();
				String line = reader.readLine();

				while (line != null && line != "'\r\n") {
					int count = 1;
					if (countMap.containsKey(line)) {
						count = countMap.get(line) + 1;
						countMap.put(line, count);
					} else {
						countMap.put(line, 1);
					}
					heap = fileHeaps.get(i);
					// 堆满
					if (heap.getCount() >= 100) {
						if (heap.getArr()[1] instanceof Word) {
							Word minWord = (Word) heap.getArr()[1];
							if (count > minWord.getCount()) {
								heap.deleteFirst();
								heap.insert(new Word(line, count));
							}
						}
					} else {
						heap.insert(new Word(line, count));
					}
					line = reader.readLine();
				}
			}
			return heap;
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		File bigFile = init();
		top10(bigFile);
		long end = System.currentTimeMillis();
		finalHeap.print();
		finalHeap.heapSort();
		finalHeap.print();
		System.out.println("spend time:" + (end - start) / 1000 + "s");
	}
}
