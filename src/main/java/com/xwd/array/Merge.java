package com.xwd.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-10 15:39
 **/
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (i + 1 < intervals.length && intervals[i][1] < intervals[i + 1][0]) {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            } else {
                list.add(intervals[i][0]);
                int post = intervals[i][1];
                while (i + 1 < intervals.length && post >= intervals[i + 1][0]) {
                    post = Math.max(post, intervals[i + 1][1]);
                    i++;
                }
                list.add(post);
            }
            resList.add(list);
        }
        int[][] res = new int[resList.size()][2];
        int i = 0;
        for (List<Integer> list : resList) {
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] arr = new int[][]{{1, 4}, {2, 3}};
        int[][] res = merge.merge(arr);
        print(res);
    }

    private static void print(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
