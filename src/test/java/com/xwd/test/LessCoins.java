package com.xwd.test;

public class LessCoins {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		/**
		 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。 如果我们要支付 w 元，求最少需要多少个硬币。 比如，我们有 3 种不同的硬币，
		 * 1元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
		 */
		int[] coins = { 1, 5, 3 };
		int total = 9;
		// int[] coins = {1, 5, 11, 1, 5, 7, 1, 15};
		// int min = lessCoins1(coins, total);

		lessCoins2(coins, total, 0);
		System.out.println(min);
//		System.out.println(new LessCoins().isPalindrome(121));

	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int ret = 0;
		int k = x;
		while (x > 0) {
			int t = x % 10;
			ret = ret * 10 + t;
			x = x / 10;
		}
		if (ret == k) {
			return true;
		} else {
			return false;
		}
	}

	/* 题目2：固定面值，硬币数目不唯一 */
	private static void lessCoins2(int[] coins, int total, int count) {
		if (total == 0) {
			if (min > count) {
				System.out.println("count=" + count + ",min=" + min);
//				System.out.println();
				min = count;
				return;
			}
		}
		for (int i = 0; i < coins.length; i++) {
			if (total >= coins[i]) {
//				System.out.println("coins[i]=" + coins[i] + ",total=" + total + ",count=" + count);
				lessCoins2(coins, total - coins[i], count + 1);
			}
		}
	}
}
