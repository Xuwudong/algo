package com.xwd.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-10 17:40
 **/
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
//        System.out.println(grayCode.toInteger("10"));
//        System.out.println(grayCode.toInteger("11"));
//        System.out.println(grayCode.toInteger("101"));
        List<Integer> res = grayCode.grayCode(2);
        System.out.println(res);
        int head = 1;
        for(int i = 0;i < 3; i++) {
            System.out.println(head <<=1 );
        }
    }

}
