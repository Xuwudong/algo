package com.xwd.backtracking;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-10 10:18
 **/
public class Exist {

    private boolean exist = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] used = new boolean[board.length][board[i].length];
                dfs(i, j, board, word, 0, used);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(int row, int col, char[][] board, String word, int index, boolean[][] used) {
        if (board[row][col] == word.charAt(index)) {
            used[row][col] = true;

            if (index + 1 == word.length()) {
                exist = true;
                return;
            }

            if (row + 1 < board.length && !used[row + 1][col]) {
                dfs(row + 1, col, board, word, index + 1, used);
            }
            if (col + 1 < board[row].length && !used[row][col + 1]) {
                dfs(row, col + 1, board, word, index + 1, used);
            }
            if (row - 1 >= 0 && !used[row - 1][col]) {
                dfs(row - 1, col, board, word, index + 1, used);
            }
            if (col - 1 >= 0 && !used[row][col - 1]) {
                dfs(row, col - 1, board, word, index + 1, used);
            }
            used[row][col] = false;
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][];
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(new Exist().exist(board, "a"));
        System.out.println(new Exist().exist(board, "ABCCED"));
        System.out.println(new Exist().exist(board, "SEE"));
        System.out.println(new Exist().exist(board, "ABCB"));
    }
}
