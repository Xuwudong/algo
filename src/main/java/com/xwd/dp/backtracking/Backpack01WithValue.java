package com.xwd.dp.backtracking;

public class Backpack01WithValue {
	public int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] states = new int[n][w + 1];
		for (int i = 0; i < n; ++i) { // 初始化 states
			for (int j = 0; j < w + 1; ++j) {
				states[i][j] = -1;
			}
		}
		states[0][0] = 0;
		states[0][weight[0]] = value[0];
		for (int i = 1; i < n; ++i) { // 动态规划，状态转移
			for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
				if (states[i - 1][j] >= 0)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
				if (states[i - 1][j] >= 0) {
					int v = states[i - 1][j] + value[i];
					if (v > states[i][j + weight[i]]) {
						states[i][j + weight[i]] = v;
					}
				}
			}
		}
		// 找出最大值
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[n - 1][j] > maxvalue)
				maxvalue = states[n - 1][j];
		}
		return maxvalue;
	}

	private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
	private int[] weight = { 2, 2, 4, 6, 3 }; // 物品的重量
	private int[] value = { 3, 4, 8, 9, 6 }; // 物品的价值
	private int n = 5; // 物品个数
	private int w = 9; // 背包承受的最大重量

	public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
		if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
			if (cv > maxV)
				maxV = cv;
			return;
		}
		f(i + 1, cw, cv); // 选择不装第 i 个物品
		if (cw + weight[i] <= w) {
			f(i + 1, cw + weight[i], cv + value[i]); // 选择装第 i 个物品
		}
	}

	public int knapsack4(int[] weight, int[] value, int n, int w) {
		int[] states = new int[w + 1];
		for (int j = 0; j < w + 1; ++j) {
			states[j] = -1;
		}
		states[0] = 0;
		states[weight[0]] = value[0];
		for (int i = 1; i < n; ++i) { // 动态规划，状态转移
			for (int j = w - weight[i]; j >= 0; --j) { // 选择第 i 个物品
				if (states[j] >= 0) {
					int v = states[j] + value[i];
					if (v > states[j + weight[i]]) {
						states[j + weight[i]] = v;
					}
				}
			}
		}
		// 找出最大值
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[j] > maxvalue)
				maxvalue = states[j];
		}
		return maxvalue;
	}

	public static void main(String[] args) {
		Backpack01WithValue b = new Backpack01WithValue();
		int[] weights = { 2, 2, 4, 6, 3 }; // 物品的重量
		int[] value = { 3, 4, 8, 9, 6 }; // 物品的价值
		int n = 5; // 物品个数
		int w = 9; // 背包承受的最大重量
		System.out.println(b.knapsack3(weights, value, n, w));
		System.out.println(b.knapsack4(weights, value, n, w));
//		b.f(0, 0, 0);
//		System.out.println(b.maxV);
	}
}