package com.xwd.binarysearch;

public class Solution {

	/**
	 * 获取第一个等于给定值的元素
	 *
	 * @param arr
	 * @param val
	 * @return
	 */
	public int getFirstEle(int[] arr, int val) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] > val) {
				end = mid - 1;
			} else if (arr[mid] < val) {
				start = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] != val)
					return mid;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 获取最后一个等于给定值的元素
	 *
	 * @param arr
	 * @param val
	 * @return
	 */
	public int getLastEle(int[] arr, int val) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] > val) {
				end = mid - 1;
			} else if (arr[mid] < val) {
				start = mid + 1;
			} else {
				if (mid == arr.length - 1 || arr[mid + 1] != val)
					return mid;
				else
					start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 查找第一个大于等于给定值的元素
	 *
	 * @param arr
	 * @param val
	 * @return
	 */
	public int getFirstGteEle(int[] arr, int val) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] < val) {
				start = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] < val)
					return mid;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 查找最后一个小于等于给定值的元素
	 *
	 * @param arr
	 * @param val
	 * @return
	 */
	public int getFirstLteEle(int[] arr, int val) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] > val) {
				end = mid - 1;
			} else {
				if (mid == arr.length - 1 || arr[mid + 1] > val)
					return mid;
				else
					start = mid + 1;
			}
		}
		return -1;
	}

	public int binarySearch(int[] arr, int val) {
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) >> 1);
			if (arr[mid] == val) {
				return mid;
			} else if (arr[mid] < val) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 循环数组的二分查找（递归版本）
	 *
	 * @param arr
	 * @param val
	 * @return
	 */
	public int binarySearchCircle(int[] arr, int val) {
		return search(arr, 0, arr.length - 1, val);
	}

	private int search(int[] arr, int low, int high, int target) {
		if (low > high)
			return -1;
		int mid = low + ((high - low) >> 1);
		if (arr[mid] == target) {
			return mid;
		}
		if (arr[mid] < arr[high]) {
			// mid - high 有序
			if (arr[mid] < target && arr[high] >= target) {
				return search(arr, mid + 1, high, target);
			} else {
				return search(arr, low, mid - 1, target);
			}
		} else {
			// low - mid 有序
			if (arr[mid] > target && arr[low] <= target) {
				return search(arr, low, mid - 1, target);
			} else {
				return search(arr, mid + 1, high, target);
			}
		}
	}

	/**
	 * 循环数组的二分查找
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + ((r - l) >> 1);
			if (nums[mid] == target)
				return mid;
			if (mid == l)
				l++;
			else if (nums[mid] > nums[l]) {
				// mid - r 有序
				if (nums[l] <= target && nums[mid] > target)
					r = mid - 1;
				else
					l = mid + 1;
			} else {
				// l - mid 有序
				if (nums[r] >= target && nums[mid] < target)
					l = mid + 1;
				else
					r = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 6, 7, 7, 7, 7, 8, 9, 10 };
		System.out.println(new Solution().getFirstEle(arr, 7));
		System.out.println(new Solution().getLastEle(arr, 7));
		System.out.println(new Solution().getFirstGteEle(arr, 5));
		System.out.println(new Solution().getFirstLteEle(arr, 8));
		int[] arr2 = { 4, 5, 6, 1, 2, 3 };
		for (int i = 1; i < 7; i++) {
			System.out.print(new Solution().binarySearchCircle(arr2, i) + "  ");
		}
		for (int i = 1; i < 7; i++) {
			System.out.print(new Solution().search(arr2, i) + "  ");
		}
	}
}
