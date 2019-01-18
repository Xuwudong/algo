package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {
	private static int count = 0;

	public static void main(String[] args) {
		while (count < 100) {
			for (int i = 0; i < 100; i++) {
				try (BufferedReader br = new BufferedReader(
						new InputStreamReader(new FileInputStream(new File("E:\\data\\mergeFileData\\test" + i))))) {
					String line = br.readLine();
					if (line != null) {
						System.out.println(line);
					} else {
						count++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
