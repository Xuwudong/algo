package com.xwd.backtracking;

import java.util.*;


//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 191 👎 0

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-02 13:11
 **/
public class Permutation {

    public String[] permutation(String s) {
        char[] c = s.toCharArray();
        Set<String> list = new HashSet<>();
        dfs(list, c, 0);
        return list.toArray(new String[0]);
    }

    private void dfs(Set<String> list, char[] arr, int index) {
        if (index == arr.length) {
            list.add(String.valueOf(arr));
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            dfs(list, arr, index + 1);
            swap(arr, i, index);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
       String[] arr = new Permutation().permutation("abc");
       for(String s: arr) {
           System.out.print(s + "\t");
       }
    }
}
