package com.xwd.stringmatch;

public class KMP {
	// b 表示模式串，m 表示模式串的长度
	private static int[] getNexts(char[] b, int m) {
		int[] next = new int[m]; // 索引代表长度，值代表此长度的模式串的最长前缀子串的最后字符的索引
		next[0] = -1;
		int k = -1;
		for (int i = 1; i < m; ++i) {
			while (k != -1 && b[k + 1] != b[i]) {
				k = next[k];
			}
			if (b[k + 1] == b[i]) {
				++k;
			}
			next[i] = k;
		}
		return next;
	}

	// a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
	public static int kmp(char[] a, int n, char[] b, int m) {
		int[] next = getNexts(b, m);
		int j = 0;// j 比较索引
		for (int i = 0; i < n; ++i) {
			while (j > 0 && a[i] != b[j]) { // 一直找到 a[i] 和 b[j]
				j = next[j - 1] + 1; 
			}
			if (a[i] == b[j]) {
				++j;
			}
			if (j == m) { // 找到匹配模式串的了
				return i - m + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		char[] a = "abcdefgfegreag".toCharArray();
		char[] b = "grea".toCharArray();
		System.out.println(kmp(a, a.length, b, b.length));
	}
}
