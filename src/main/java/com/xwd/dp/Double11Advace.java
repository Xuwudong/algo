package com.xwd.dp;

public class Double11Advace {
	// items ��Ʒ�۸�n ��Ʒ����, w ��ʾ�������������� 200
	public static void double11advance(int[] items, int n, int w) {
		boolean[][] states = new boolean[n][3 * w + 1];// ���� 3 ����û��޶��ë�ļ�ֵ��
		states[0][0] = true; // ��һ�е�����Ҫ���⴦��
		states[0][items[0]] = true;
		for (int i = 1; i < n; ++i) { // ��̬�滮
			for (int j = 0; j <= 3 * w; ++j) {// ������� i ����Ʒ
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= 3 * w - items[i]; ++j) {// ����� i ����Ʒ
				if (states[i - 1][j] == true)
					states[i][j + items[i]] = true;
			}
		}

		int j;
		for (j = w; j < 3 * w + 1; ++j) {
			if (states[n - 1][j] == true)
				break; // ���������ڵ��� w ����Сֵ
		}
		if (j == 3 * w + 1)
			return; // û�п��н�
		for (int i = n - 1; i >= 1; --i) { // i ��ʾ��ά�����е��У�j ��ʾ��
			if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
				System.out.print(items[i] + " "); // ���������Ʒ
				j = j - items[i];
			} // else û�й��������Ʒ��j ���䡣
		}
		if (j != 0)
			System.out.print(items[0]);
	}
	public static void main(String[] args) {
		int[] items = {30,30,34,56,67,78,988,545,34,54,31,34,43,5432,23,32,67,87};
		Double11Advace.double11advance(items, items.length, 200);
	}

}
