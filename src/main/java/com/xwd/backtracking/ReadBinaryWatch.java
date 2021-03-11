package com.xwd.backtracking;

import java.util.*;

/**
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * 通过次数24,800提交次数46,360
 */
public class ReadBinaryWatch {
    int[] hours = new int[]{1, 2, 4, 8};
    int[] mins = new int[]{1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        dfs(res, num, 0, 0, 0, 0);
        return res;
    }


    /**
     * dfs
     *
     * @param res    结果集
     * @param num    灯的个数
     * @param indexH hours的索引
     * @param indexM mins的索引
     * @param hour   当前hour的值
     * @param min    当前min的值
     */
    private void dfs(List<String> res, int num, int indexH, int indexM, int hour, int min) {
        if (num == 0) {
            // 递归结束条件为num == 0,注意不是indexH + indexM == num, 因为indexH表示的是hours的索引。
            String minStr = (0 <= min && min <= 9) ? "0" + min : min + "";
            String str = hour + ":" + minStr;
            res.add(str);
            return;
        }
        // 这种循环结构就是求hours的子集，此题就是求hours求指定长度的各个子集的和
        for (int i = indexH; i < hours.length; i++) {
            if (hour + hours[i] >= 12) {
                // 如果大于12，后面的循环不用看了，直接break
                break;
            }
            dfs(res, num - 1, i + 1, indexM, hour + hours[i], min);
            // dfs后不用回溯是因为dfs前并没有改变hour的值
        }
        for (int i = indexM; i < mins.length; i++) {
            if (min + mins[i] >= 60) {
                // 如果大于60，后面的循环不用看了，直接break
                break;
            }
            // 注意这里递归到mins时，并不需要再次递归到hours,不然结果会重复,所以indexH填4
            dfs(res, num - 1, 4, i + 1, hour, min + mins[i]);
            // dfs后不用回溯是因为dfs前并没有改变min的值
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReadBinaryWatch().readBinaryWatch(2));
    }
}
