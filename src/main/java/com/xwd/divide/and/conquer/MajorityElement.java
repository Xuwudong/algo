package com.xwd.divide.and.conquer;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 位运算 数组 分治算法
// 👍 944 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-07 10:51
 **/
public class MajorityElement {
    class Status {
        int val;
        int count;

        public Status(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1).val;
    }

    private Status majorityElement(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], 1);
        }
        int m = (l + r) >> 1;
        return pickUp(majorityElement(nums, l, m), majorityElement(nums, m + 1, r));
    }

    private Status pickUp(Status s1, Status s2) {
        if (s1.val == s2.val) {
            s1.count += s2.count;
            return s1;
        } else {
            if (s1.count >= s2.count) {
                s1.count = s1.count - s2.count;
                return s1;
            } else {
                s2.count = s2.count - s1.count;
                return s2;
            }
        }
    }
}
