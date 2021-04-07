package com.xwd.heaps;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 983 👎 0



/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-07 14:45
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);

        int i = nums.length - 1;
        while (k > 1) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
            k--;
            i--;
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        while (true) {
            int maxPos = i;
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < heapSize && nums[l] > nums[i]) {
                maxPos = l;
            }
            if (r < heapSize && nums[r] > nums[maxPos]) {
                maxPos = r;
            }
            if (maxPos == i) {
                break;
            }
            swap(nums, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
