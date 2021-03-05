package com.xwd.recursion;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-05 17:10
 **/
public class Tribonacci {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(3));
    }
}
