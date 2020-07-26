package com.xwd.doublepointer;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Trap {
    public int trap(int[] a) {
        int i = 0;
        int j = a.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int res = 0;
        while (i < j) {
            if (a[i] < a[j]) {
                if (a[i] >= maxLeft) {
                    maxLeft = a[i];
                } else {
                    res += maxLeft - a[i];
                }
                i++;
            } else {
                if (a[j] >= maxRight) {
                    maxRight = a[j];
                } else {
                    res += maxRight - a[j];
                }
                j--;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
