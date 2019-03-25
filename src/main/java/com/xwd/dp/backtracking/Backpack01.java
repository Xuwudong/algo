package com.xwd.dp.backtracking;

public class Backpack01 {
	private int maxW = Integer.MIN_VALUE;// 存储背包中物品总重量的最大值

	/**
	 * 回溯解决01背包问题;
	 * 
	 * @param i   表示考察到哪个物品了
	 * @param cw  表示当前已装进去的物品总重量的和
	 * @param arr 存储每个物品的重量
	 * @param w   背包能承受的重量
	 */
	public void f(int i, int cw, int[] arr, int w) {
		if (cw >= w || i == arr.length) {
			if (cw > maxW) {
				maxW = cw;
			}
			return;
		}
		// i 物品不放进背包
		f(i + 1, cw, arr, w);
		if (cw + arr[i] <= w) {
			// i 物品放进背包
			f(i + 1, cw + arr[i], arr, w);
		}
	}

	private int[] weights = { 2, 3, 9, 4 };
	private int w = 10;
	private boolean[][] mem = new boolean[4][10]; // 备忘录

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

	// weight: 物品重量，n: 物品个数，w: 背包可承载重量
	public int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1]; // 默认值 false
		states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		states[0][weight[0]] = true;
		for (int i = 1; i < n; ++i) { // 动态规划状态转移
			for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j + weight[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[n - 1][i] == true)
				return i;
		}
		return 0;
	}

	public int knapsack2(int[] items, int n, int w) {
		boolean[] states = new boolean[w + 1]; // 默认值 false
		states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		states[items[0]] = true;
		for (int i = 1; i < n; ++i) { // 动态规划
			for (int j = w - items[i]; j >= 0; j--) {// 把第 i 个物品放入背包
				if (states[j] == true)
					states[j + items[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
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
