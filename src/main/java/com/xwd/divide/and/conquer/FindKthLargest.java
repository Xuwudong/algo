package com.xwd.divide.and.conquer;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-07 12:02
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) >> 1;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        pickUp(nums, l, m, r);
    }

    private void pickUp(int[] nums, int l, int m, int r) {
         int i = l, j = m + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= m && j <= r) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[i];
                i++;
            } else {
                temp[k++] = nums[j];
                j++;
            }
        }
        while (i <= m) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }

        for (int x = l; x <= r; x++) {
            nums[x] = temp[x - l];
        }
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{2, 1}, 2));
    }

}
