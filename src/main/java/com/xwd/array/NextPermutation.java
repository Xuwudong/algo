package com.xwd.array;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 1045 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-09 11:02
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int lastUpIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                lastUpIndex = i - 1;
            }
        }

        if (lastUpIndex != -1) {
            int j = nums.length -1;
            while (j >= 0 && nums[lastUpIndex] >= nums[j]) {
                j--;
            }
            swap(nums, lastUpIndex, j);
        }
        reverse(nums, lastUpIndex + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1,2,3};
        nextPermutation.nextPermutation(nums);
        for(int i : nums) {
            System.out.print(i +"  ");
        }
    }
}
