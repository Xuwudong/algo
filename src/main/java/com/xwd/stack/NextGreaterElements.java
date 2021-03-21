package com.xwd.stack;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * @Author LXT
 * @create 2021/3/21 19:06
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int pre = stack.pop();
                res[pre] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int pre = stack.pop();
                res[pre] = nums[i];
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElements().nextGreaterElements(new int[]{1, 2, 1}));
    }
}
