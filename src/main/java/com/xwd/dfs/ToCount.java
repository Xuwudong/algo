package com.xwd.dfs;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-05-17 20:02
 **/
public class ToCount {

    private int res;

    public int toCount(int i, int j, int l) {
        if (l == 0) {
            return 0;
        }
        dfs(i, j, 1, l);
        return res;
    }

    private void dfs(int i, int j, int count, int l) {
        if (i < 0 || i > 3 || j < 0 || j > 3) {
            return;
        }
        if (count == l) {
            res++;
            return;
        }
        dfs(i - 2, j - 1, count + 1, l);
        dfs(i - 2, j + 1, count + 1, l);

        dfs(i - 1, j - 2, count + 1, l);
        dfs(i - 1, j + 2, count + 1, l);

        dfs(i + 2, j + 1, count + 1, l);
        dfs(i + 2, j - 1, count + 1, l);

        dfs(i + 1, j + 2, count + 1, l);
        dfs(i + 1, j - 2, count + 1, l);
    }

    public static void main(String[] args) {
        ToCount main = new ToCount();
        System.out.println(main.toCount(0, 0, 1));
        main = new ToCount();
        System.out.println(main.toCount(0, 0, 2));
        main = new ToCount();
        System.out.println(main.toCount(0, 0, 3));
        main = new ToCount();
        System.out.println(main.toCount(0, 0, 4));
    }
}
