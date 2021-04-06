package com.xwd.divide.and.conquer;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：0
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：-1
//
//
// 示例 5：
//
//
//输入：nums = [-100000]
//输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治算法 动态规划
// 👍 3103 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-06 21:06
 **/
public class MaxSubArray {
    class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getStatus(nums, 0, nums.length - 1).mSum;
    }

    private Status getStatus(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[r], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        return pushUp(getStatus(nums, l, m), getStatus(nums, m + 1, r));
    }

    private Status pushUp(Status s1, Status s2) {
        int lSum = Math.max(s1.lSum, s1.iSum + s2.lSum);
        int rSum = Math.max(s2.rSum, s1.rSum + s2.iSum);
        int mSum = Math.max(Math.max(s1.mSum, s2.mSum), s1.rSum + s2.lSum);
        int iSum = s1.iSum + s2.iSum;
        return new Status(lSum, rSum, mSum, iSum);
    }
}
