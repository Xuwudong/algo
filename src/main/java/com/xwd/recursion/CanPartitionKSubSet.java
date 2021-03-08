package com.xwd.recursion;

import java.util.Arrays;

/**
 * @program: algo
 * @description: 698
 * @author: xuwudong
 * @create: 2021-03-08 19:28
 **/
public class CanPartitionKSubSet {

    private boolean canPartitionKSubSet(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {
            return true;
        }
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6};
//        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        CanPartitionKSubSet c = new CanPartitionKSubSet();
        System.out.println(c.canPartitionKSubSet(nums, 3));
    }
}
