package LeetCode.game_of_life;

import java.util.Arrays;

public class Solution {

    /**
     * copy原数组作为原始数组，之后修改原始数组
     * @param board 给定的数组
     */
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] copy = new int[n][m];
        int sum;

        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(board[i],m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                sum = 0;
                for (int k = i-1; k < i+2; k++) {
                    for (int l = j-1; l < j+2; l++) {
                        if ( k < 0 || l < 0 || k >= n || l >=m || copy[k][l] == 0) continue;
                        sum++;
                    }
                }

                if (copy[i][j] == 1) {
                    if (sum == 3 || sum == 4) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
                else {
                    if (sum == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
