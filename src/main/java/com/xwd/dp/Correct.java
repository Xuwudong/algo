package com.xwd.dp;

/**
 * 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？ 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，
 * 它的最长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
 * 
 * @author admin
 *
 */
public class Correct {
	/**
	 * 递归
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int solution(int[] arr, int n) {
		if (n == 0) {
			return 1;
		}
		if (n - 1 >= 0 && arr[n] >= arr[n - 1]) {
			return solution(arr, n - 1) + 1;
		} else {
			return solution(arr, n - 1);
		}
	}

	/**
	 * 动态规划
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int longestIncreaseSubArrayDP(int[] array) {
		if (array.length < 2)
			return array.length;
		int[] state = new int[array.length];
		state[0] = 1;
		for (int i = 1; i < state.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					if (state[j] > max)
						max = state[j];
				}
			}
			state[i] = max + 1;
		}
		int result = 0;
		for (int i = 0; i < state.length; i++) {
			if (state[i] > result)
				result = state[i];
		}
		return result;
	}

	/**
	 * 动态规划
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public int solution2(int[] arr, int n) {
		if (n == 0) {
			return 1;
		}
		int[] len = new int[n];
		len[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					if (len[j] > max) {
						max = len[j];
					}
				}
			}
			len[i] = max + 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (len[i] != 0) {
				return len[i];
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Correct c = new Correct();
		int[] arr = { 2, 9, 3, 6, 4, 5, 7 };
		System.out.println(c.solution(arr, arr.length - 1));
		System.out.println(c.solution2(arr, arr.length));
	}
}
