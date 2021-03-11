package com.xwd.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
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
