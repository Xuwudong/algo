package com.xwd.binarysearch;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,4,2,2]
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [3,1,3,4,2]
//输出：3
//
//
// 示例 3：
//
//
//输入：nums = [1,1]
//输出：1
//
//
// 示例 4：
//
//
//输入：nums = [1,1,2]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
//
// Related Topics 数组 双指针 二分查找
// 👍 1242 👎 0


/**
 * @program: algo
 * @description: 287寻找重复数
 * @author: xuwudong
 * @create: 2021-06-10 17:24
 **/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        while (l <= r) {
            int count = 0;
            int mid = (l + r) >> 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
