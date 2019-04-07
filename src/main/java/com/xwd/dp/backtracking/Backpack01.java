package com.xwd.dp.backtracking;

public class Backpack01 {
	private int maxW = Integer.MIN_VALUE;// �洢��������Ʒ�����������ֵ

	/**
	 * ���ݽ��01��������;
	 * 
	 * @param i   ��ʾ���쵽�ĸ���Ʒ��
	 * @param cw  ��ʾ��ǰ��װ��ȥ����Ʒ�������ĺ�
	 * @param arr �洢ÿ����Ʒ������
	 * @param w   �����ܳ��ܵ�����
	 */
	public void f(int i, int cw, int[] arr, int w) {
		if (cw >= w || i == arr.length) {
			if (cw > maxW) {
				maxW = cw;
			}
			return;
		}
		// i ��Ʒ���Ž�����
		f(i + 1, cw, arr, w);
		if (cw + arr[i] <= w) {
			// i ��Ʒ�Ž�����
			f(i + 1, cw + arr[i], arr, w);
		}
	}

	private int[] weights = { 2, 3, 9, 4 };
	private int w = 10;
	private boolean[][] mem = new boolean[4][10]; // ����¼

	public void f2(int i, int cw) {
		if (cw == w || i == weights.length) {
			if (cw > maxW) {
				maxW = cw;
			}
			return;
		}
		if (mem[i][cw]) {
			return;
		}
		mem[i][cw] = true;
		f2(i + 1, cw);
		if (cw + weights[i] <= w) {
			f2(i + 1, cw + weights[i]);
		}
	}

	// weight: ��Ʒ������n: ��Ʒ������w: �����ɳ�������
	public int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1]; // Ĭ��ֵ false
		states[0][0] = true; // ��һ�е�����Ҫ���⴦�����������ڱ��Ż�
		states[0][weight[0]] = true;
		for (int i = 1; i < n; ++i) { // ��̬�滮״̬ת��
			for (int j = 0; j <= w; ++j) {// ���ѵ� i ����Ʒ���뱳��
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) {// �ѵ� i ����Ʒ���뱳��
				if (states[i - 1][j] == true)
					states[i][j + weight[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // ������
			if (states[n - 1][i] == true)
				return i;
		}
		return 0;
	}

	public int knapsack2(int[] items, int n, int w) {
		boolean[] states = new boolean[w + 1]; // Ĭ��ֵ false
		states[0] = true; // ��һ�е�����Ҫ���⴦�����������ڱ��Ż�
		states[items[0]] = true;
		for (int i = 1; i < n; ++i) { // ��̬�滮
			for (int j = w - items[i]; j >= 0; j--) {// �ѵ� i ����Ʒ���뱳��
				if (states[j] == true)
					states[j + items[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // ������
			if (states[i] == true)
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 9, 4 };
		Backpack01 b = new Backpack01();
//		b.f(0, 0, arr, 10);
//		b.f2(0, 0);
//		System.out.println(b.maxW);

//		System.out.println(b.knapsack(arr, 4, 10));
		System.out.println(b.knapsack2(arr, 4, 10));
	}
}
