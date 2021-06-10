package com.xwd.array;

import java.util.ArrayList;
import java.util.List;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
//
//
// 示例 2：
//
//
//输入：nums = [1,1]
//输出：[2]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
//
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
// Related Topics 数组
// 👍 751 👎 0


/**
 * @program: algo
 * @description: 448 找到所有数组中消失的数字
 * @author: xuwudong
 * @create: 2021-06-10 17:20
 **/
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int num: nums) {
            int index  = (num - 1) % n;
            nums[index] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
