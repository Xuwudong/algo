package com.xwd.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 堆 分治算法
// 👍 219 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-31 10:31
 **/
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });
        for (int i : arr) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (queue.peek() > i) {
                queue.poll();
                queue.add(i);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (queue.size() > 0) {
            res[i++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new GetLeastNumbers().getLeastNumbers(new int[]{3, 2, 1}, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
