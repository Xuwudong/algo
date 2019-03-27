package com.xwd.dp;

/**
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。 如果我们要支付 w 元，求最少需要多少个硬币。 比如，我们有 3 种不同的硬币，1
 * 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
 * 
 * @author admin
 *
 */
public class Coin {
	private int[] mem = new int[10000];

	/**
	 * 回溯+备忘录
	 * 
	 * @param n
	 * @return
	 */
	public int solution(int n) {
		if (n <= 0) {
			return 2;
		}
		if (mem[n] > 0) {
			return mem[n];
		}
		if (n == 1 || n == 3 || n == 5) {
			mem[n] = 1;
			return 1;
		}
		int n1 = solution(n - 1) + 1;
		int n2 = solution(n - 3) + 1;
		int n3 = solution(n - 5) + 1;
		int res = n1 > n2 ? n2 : n1;
		res = res > n3 ? n3 : res;
		mem[n] = res;
		return res;
	}

	/**
	 * 动态规划
	 * 
	 * @param money
	 * @return
	 */
	public int minCoins(int money) {
		if (money == 1 || money == 3 || money == 5)
			return 1;
		// 横坐标表示层数，纵坐标表示钱
		boolean[][] state = new boolean[money][money + 1];
		if (money >= 1)
			state[0][1] = true;
		if (money >= 3)
			state[0][3] = true;
		if (money >= 5)
			state[0][5] = true;
		for (int i = 1; i < money; i++) {
			for (int j = 1; j <= money; j++) {
				if (state[i - 1][j]) {
					if (j + 1 <= money)
						state[i][j + 1] = true;
					if (j + 3 <= money)
						state[i][j + 3] = true;
					if (j + 5 <= money)
						state[i][j + 5] = true;
					if (state[i][money])
						return i + 1;
				}
			}
		}
		return money;
	}

	public static void main(String[] args) {
		Coin c = new Coin();
		long start = System.currentTimeMillis();
		System.out.println(c.minCoins(9999));
//		System.out.println(c.solution(9999));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
//		System.out.println(c.solution(1));
//		System.out.println(c.solution(2));
//		System.out.println(c.solution(3));
//		System.out.println(c.solution(4));
//		System.out.println(c.solution(5));
//		System.out.println(c.solution(6));
//		System.out.println(c.solution(7));
//		System.out.println(c.solution(10));
	}
}
