package com.xwd.util;

import java.util.List;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-02 11:36
 **/
public class ListUtil {
    public static void print(List<List<Integer>> list) {
        for (List<Integer> list1 : list) {
            System.out.print(list1 + "\t");
        }
    }
}
