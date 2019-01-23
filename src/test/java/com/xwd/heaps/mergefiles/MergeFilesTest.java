package com.xwd.heaps.mergefiles;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


/**
 * 合并文件
 *
 * @author APP
 */
public class MergeFilesTest {

	@Test
	public void mergeFiles() throws IOException {
		long start = System.currentTimeMillis();

		// 初始化小文件和大文件
		String path = "D:\\data\\mergeFileData";
		MergeFiles.create(path);
		MergeFiles.init(new File(path));
		File bigFile = MergeFiles.createBigFile();
		// 移动数据
		MergeFiles.initHeap(bigFile);
		MergeFiles.move(bigFile);
		long end = System.currentTimeMillis();
		System.out.println("spend time:" + (end - start) / 1000 + "s");
	}
}
