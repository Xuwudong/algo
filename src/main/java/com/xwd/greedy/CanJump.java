package com.xwd.greedy;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-10 10:37
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
