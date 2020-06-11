package LeetCode.game_of_life;

public class Solution2 {

    /**
     * 空间优化 之前是直接copy原数组作为生命游戏的原数组
     * 现在不需要开辟新的空间 O(1)的空间复杂度
     * 增加新的状态
     * 0：死亡
     * 1：存活
     * -1：由存活转到死亡，之前是存活状态
     * 2：有死亡转到存活，之前是死亡状态
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum = 0;
                for (int k = i-1; k < i+2; k++) {
                    for (int l = j-1; l < j+2; l++) {
                        if (k < 0 || l < 0 || k >= n || l >= m || board[k][l] == 0 || board[k][l] == 2) continue;
                        sum++;
                    }
                }
                if (board[i][j] == 1 && (sum != 3 && sum != 4)) {
                    board[i][j] = -1;
                }
                else if (board[i][j] == 0 && sum == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
