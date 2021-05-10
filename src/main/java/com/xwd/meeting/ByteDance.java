package com.xwd.meeting;

import java.util.*;

public class ByteDance {
    public static void main(String[] args) {
        List<int[]> arrList = new ArrayList<>();
        arrList.add(new int[]{1, 3, 3, 10});
        arrList.add(new int[]{5, 7, 15, 18});
        arrList.add(new int[]{2, 15, 17, 20});
        ByteDance main = new ByteDance();
        int[] res = main.sort(arrList);
        for (int i : res) {
            System.out.print(i + "  ");
        }
    }

    public int[] sort(List<int[]> arrList) {
        return sort(arrList, 0, arrList.size() - 1);
    }

    private int[] sort(List<int[]> arrList, int l, int r) {
        if (l >= r) {
            return arrList.get(l);
        }
        int mid = (l + r) / 2;
        int[] left = sort(arrList, l, mid);
        int[] right = sort(arrList, mid + 1, r);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                res[i++] = left[l++];
            } else {
                res[i++] = right[r++];
            }
        }
        while (l < left.length) {
            res[i++] = left[l++];
        }
        while (r < right.length) {
            res[i++] = right[r++];
        }
        return res;
    }
}
