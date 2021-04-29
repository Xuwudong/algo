package com.xwd.dp;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 动态规划
// 👍 752 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-27 10:46
 **/
public class MaximalSquare {
    /**
     * 如果该位置的值是 0，则 textitdpij0  ，因为当前位置不可能在由 1 组成的正方形中；
     *
     * 如果该位置的值是 1，则 textitdpij  的值由其上方、左方和左上方的三个相邻位置的 textitdp  值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
     *
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     *
     * 如果读者对这个状态转移方程感到不解，可以参考 1277. 统计全为 1 的正方形子矩阵的官方题解，其中给出了详细的证明。
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (res < dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        MaximalSquare main = new MaximalSquare();
        System.out.println(main.maximalSquare(new char[][]{{'1','1','1','0','0'},{'1','1','1','0','0'},{'1','1','1','1','1'},{'0','1','1','1','1'},{'0','1','1','1','1'},{'0','1','1','1','1'}}));
    }
}
