package com.xwd.dp;

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
