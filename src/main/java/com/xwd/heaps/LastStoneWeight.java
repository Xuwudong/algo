package com.xwd.heaps;

import java.util.*;

//有一堆石头，每块石头的重量都是正整数。
//
// 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//
// 如果 x == y，那么两块石头都会被完全粉碎；
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
//
//
//
// 示例：
//
//
//输入：[2,7,4,1,8,1]
//输出：1
//解释：
//先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
//再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
//接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
//最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
//
//
//
// 提示：
//
//
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 1000
//
// Related Topics 堆 贪心算法
// 👍 154 👎 0



/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-31 15:27
 **/
public class LastStoneWeight {
    private PriorityQueue<Integer> queue = new PriorityQueue<>(2, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    private int k = 2;

    public int lastStoneWeight(int[] stones) {

        List<Integer> list = new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }
        return dfs(list);
    }

    private int dfs(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 0) {
            return 0;
        }
        List<Integer> next = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (queue.size() < k) {
                queue.add(list.get(i));
            } else if (list.get(i) > queue.peek()) {
                next.add(queue.poll());
                queue.add(list.get(i));
            } else {
                next.add(list.get(i));
            }
        }
        int first = queue.poll();
        int second = queue.poll();
        int left = second - first;
        if (left != 0) {
            next.add(left);
        }
        return dfs(next);
    }

    public static void main(String[] args) {
//        System.out.println(new LastStoneWeight().lastStoneWeight(new int[] {2,7,4,1,8,1}));
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[] {3,7,8}));
    }
}
