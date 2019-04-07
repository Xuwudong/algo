package com.xwd.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int newTarget = target - nums[i];
				for (int j = i + 1; j < nums.length; j++) {
					if (j == i + 1 || nums[j] > nums[j - 1]) {
						int newTarget2 = newTarget - nums[j];
						int l = j + 1;
						int r = nums.length - 1;
						while (l < r) {
							int sum = nums[l] + nums[r];
							if (sum == newTarget2) {
								ArrayList<Integer> list = new ArrayList<>();
								list.add(nums[i]);
								list.add(nums[j]);
								list.add(nums[l]);
								list.add(nums[r]);
								res.add(list);
								while (l < r && nums[l] == nums[l + 1])
									l++; // 注意去重
								while (l < r && nums[r] == nums[r - 1])
									r--;
								l++;
								r--;
							} else if (sum > newTarget2) {
								r--;
							} else {
								l++;
							}
						}
					}
				}
			}
		}
		return res;
	}

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		intToRoman(num, sb);
		return sb.toString();
	}

	private void intToRoman(int num, StringBuilder sb) {
		if (num >= 1000) {
			int i = num / 1000;
			num = num - i * 1000;
			while (i-- > 0) {
				sb.append("M");
			}
		} else if (num >= 500) {
			if (num >= 900 && num <= 999) {
				sb.append("CM");
				num = num - 900;
			} else {
				sb.append("D");
				num = num - 500;
			}
		} else if (num >= 100) {
			if (num >= 400 && num <= 499) {
				sb.append("CD");
				num = num - 400;
			} else {
				int i = num / 100;
				num = num - i * 100;
				while (i-- > 0) {
					sb.append('C');
				}
			}
		} else if (num >= 50) {
			if (num >= 90 && num <= 99) {
				sb.append("XC");
				num = num - 90;
			} else {
				sb.append('L');
				num = num - 50;
			}
		} else if (num >= 10) {
			if (num >= 40 && num <= 49) {
				sb.append("XL");
				num = num - 40;
			} else {
				int i = num / 10;
				num = num - i * 10;
				while (i-- > 0) {
					sb.append("X");
				}
			}
		} else if (num >= 5) {
			if (num == 9) {
				sb.append("IX");
				num = 0;
			} else {
				sb.append('V');
				num = num - 5;
			}
		} else if (num >= 1) {
			if (num == 4) {
				sb.append("IV");
			} else {
				int i = num;
				while (i-- > 0) {
					sb.append('I');
				}
			}
			num = 0;
		} else {
			return;
		}
		intToRoman(num, sb);
	}

	private HashMap<Character, Integer> charMap = new HashMap<>();

	public int romanToInt(String s) {
		charMap.put('I', 1);
		charMap.put('V', 2);
		charMap.put('X', 3);
		charMap.put('L', 4);
		charMap.put('C', 5);
		charMap.put('D', 6);
		charMap.put('M', 7);
		int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String reps[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			String sub;
			if (i + 1 < s.length() && charMap.get(s.charAt(i + 1)) > charMap.get(s.charAt(i))) {
				sub = s.substring(i, i + 2);
				i++;
			} else {
				sub = s.substring(i, i + 1);
			}
			for (int j = 0; j < 13; j++) {
				if (sub.equals(reps[j])) {
					res += values[j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] nums = { 1, 0, -1, 0, -2, 2 };
//		System.out.println(s.fourSum(nums, 0));
//		System.out.println(s.intToRoman(3));
//		System.out.println(s.intToRoman(4));
//		System.out.println(s.intToRoman(10));
		System.out.println(s.romanToInt("III"));
//		System.out.println("I".equals("I"));
	}
}