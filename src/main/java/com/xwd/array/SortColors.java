package com.xwd.array;



/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 通过次数196,109提交次数337,430
 *
 * @Author LXT
 * @create 2021/4/11 11:37
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;int right = nums.length-1;
        for(int i = 0;i <=right;i++) {
            while (i >= left && nums[i] == 0) {
                swap(nums,left,i);
                left++;
            }
            if (nums[i] == 2) {
                swap(nums,right,i);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] arr = new int[]{2,0,1};
        sortColors.sortColors(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
