package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MergeFiles {
	public static ArrayList<File> fileList = new ArrayList<>();
	private static Heap heap = new Heap(101);

	public static void init() {

	}

	public static void main(String[] args) {
		for(File file:fileList) {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		}
	}
}
