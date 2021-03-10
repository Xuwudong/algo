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
        dfs(res, s, sb, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int index) {
        if (index >= s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < s.length();i++ ) {
            if (s.charAt(i) == '0') {
                sb.append(s.charAt(i) + ".");
                dfs(res, s, sb, index + 1);
                sb.deleteCharAt(s.length() - 1);
                i++;
            } else {
                // 取一位
                if(i < s.length() -1) {
                    String sub = s.substring(i, i + 1);
                    sb.append(sub + ".");
                    dfs(res, s, sb, index + 1);
                    sb.deleteCharAt(s.length() - 1);
                }

                if(i < s.length() - 2) {
                    // 取两位
                    String sub = s.substring(i, i + 2);
                    sb.append(sub + ".");
                    dfs(res, s, sb, index + 2);
                    sb.delete(sb.length() - 2, sb.length());
                }

                if(i < s.length() -3) {
                    String sub = s.substring(i, i + 3);
                    if (Integer.valueOf(sub) <= 255) {
                        sb.append(sub + ".");
                        dfs(res, s, sb, index + 3);
                        sb.delete(sb.length() - 3, sb.length());

                    }
                }


            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
    }
}
