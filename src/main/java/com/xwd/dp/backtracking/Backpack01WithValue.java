package com.xwd.dp.backtracking;

public class Backpack01WithValue {
	public int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] states = new int[n][w + 1];
		for (int i = 0; i < n; ++i) { // ��ʼ�� states
			for (int j = 0; j < w + 1; ++j) {
				states[i][j] = -1;
			}
		}
		states[0][0] = 0;
		states[0][weight[0]] = value[0];
		for (int i = 1; i < n; ++i) { // ��̬�滮��״̬ת��
			for (int j = 0; j <= w; ++j) { // ��ѡ��� i ����Ʒ
				if (states[i - 1][j] >= 0)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) { // ѡ��� i ����Ʒ
				if (states[i - 1][j] >= 0) {
					int v = states[i - 1][j] + value[i];
					if (v > states[i][j + weight[i]]) {
						states[i][j + weight[i]] = v;
					}
				}
			}
		}
		// �ҳ����ֵ
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[n - 1][j] > maxvalue)
				maxvalue = states[n - 1][j];
		}
		return maxvalue;
	}

	private int maxV = Integer.MIN_VALUE; // ����ŵ� maxV ��
	private int[] weight = { 2, 2, 4, 6, 3 }; // ��Ʒ������
	private int[] value = { 3, 4, 8, 9, 6 }; // ��Ʒ�ļ�ֵ
	private int n = 5; // ��Ʒ����
	private int w = 9; // �������ܵ��������

	public void f(int i, int cw, int cv) { // ���� f(0, 0, 0)
		if (cw == w || i == n) { // cw==w ��ʾװ���ˣ�i==n ��ʾ��Ʒ����������
			if (cv > maxV)
				maxV = cv;
			return;
		}
		f(i + 1, cw, cv); // ѡ��װ�� i ����Ʒ
		if (cw + weight[i] <= w) {
			f(i + 1, cw + weight[i], cv + value[i]); // ѡ��װ�� i ����Ʒ
		}
	}

	public int knapsack4(int[] weight, int[] value, int n, int w) {
		int[] states = new int[w + 1];
		for (int j = 0; j < w + 1; ++j) {
			states[j] = -1;
		}
		states[0] = 0;
		states[weight[0]] = value[0];
		for (int i = 1; i < n; ++i) { // ��̬�滮��״̬ת��
			for (int j = w - weight[i]; j >= 0; --j) { // ѡ��� i ����Ʒ
				if (states[j] >= 0) {
					int v = states[j] + value[i];
					if (v > states[j + weight[i]]) {
						states[j + weight[i]] = v;
					}
				}
			}
		}
		// �ҳ����ֵ
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[j] > maxvalue)
				maxvalue = states[j];
		}
		return maxvalue;
	}

	public static void main(String[] args) {
		Backpack01WithValue b = new Backpack01WithValue();
		int[] weights = { 2, 2, 4, 6, 3 }; // ��Ʒ������
		int[] value = { 3, 4, 8, 9, 6 }; // ��Ʒ�ļ�ֵ
		int n = 5; // ��Ʒ����
		int w = 9; // �������ܵ��������
		System.out.println(b.knapsack3(weights, value, n, w));
		System.out.println(b.knapsack4(weights, value, n, w));
//		b.f(0, 0, 0);
//		System.out.println(b.maxV);
	}
}
