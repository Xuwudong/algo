package com.xwd.backtracking.expamd;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * @program: algo
 * @description: 93
 * @author: xuwudong
 * @create: 2021-03-10 20:56
 **/
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, s, sb, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int index, int count) {

        if (index == s.length() && count == 4) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            sb.append(".");
            return;
        }
        if (count >= 4 || index >= s.length()) {
            return;
        }
        if (s.charAt(index) == '0') {
            sb.append(s.charAt(index)).append(".");
            dfs(res, s, sb, index + 1, count + 1);
            sb.delete(sb.length() - 2, sb.length());
        } else {
            // 取一位
            if (index <= s.length() - 1) {
                String sub = s.substring(index, index + 1);
                sb.append(sub).append(".");
                dfs(res, s, sb, index + 1, count + 1);
                sb.delete(sb.length() - 2, sb.length());
            }

            if (index <= s.length() - 2) {
                // 取两位
                String sub = s.substring(index, index + 2);
                sb.append(sub).append(".");
                dfs(res, s, sb, index + 2, count + 1);
                sb.delete(sb.length() - 3, sb.length());
            }

            if (index <= s.length() - 3) {
                String sub = s.substring(index, index + 3);
                if (Integer.parseInt(sub) <= 255) {
                    sb.append(sub).append(".");
                    dfs(res, s, sb, index + 3, count + 1);
                    sb.delete(sb.length() - 4, sb.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses("1111"));
    }
}
