package com.xwd.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.xwd.list.ListNode;

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
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        int mid = lists.length / 2;

        ListNode[] left = Arrays.copyOfRange(lists, 0, mid);
        ListNode[] right = Arrays.copyOfRange(lists, mid, lists.length);
        ListNode l1 = mergeKLists(left);
        ListNode l2 = mergeKLists(right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = null;

        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        s(candidates, target, list, res, 0);
        return res;
    }

    private void s(int[] arr, int target, List<Integer> list, List<List<Integer>> res, int index) {
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) {
                if (list.isEmpty()) {
                    return;
                } else {
                    int s = list.remove(list.size() - 1);
                    target = target + s;
                    s(arr, target, list, res, i + 1);
                }
            } else {
                list.add(arr[i]);
                target = target - arr[i];
                if (target == 0) {
                    res.add(list);
                    list = new ArrayList<>(list);
                    int s = list.remove(list.size() - 1);
                    target = target + s;
                    s(arr, target, list, res, i + 1);
                } else {
                    s(arr, target, list, res, i);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums,target,res,new ArrayList<Integer>(),0);
        return res;
    }

    private void backtrace(int[] nums,int remain,List<List<Integer>> res,List<Integer> list, int index){
        if (remain < 0) {
            return;
        } else if(remain == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for(int i = index;i < nums.length;i++){
                list.add(nums[i]);
                backtrace(nums,remain - nums[i],res,list,index + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//		int[] nums = { 1, 0, -1, 0, -2, 2 };
//		System.out.println(s.fourSum(nums, 0));
//		System.out.println(s.intToRoman(3));
//		System.out.println(s.intToRoman(4));
//		System.out.println(s.intToRoman(10));
//		System.out.println(s.romanToInt("III"));
//		System.out.println("I".equals("I"));
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> res = s.combinationSum2(arr, 8);
        System.out.println(res);
    }
}