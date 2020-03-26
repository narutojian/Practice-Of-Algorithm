package LeetCode;

public class P999 {

    /**
     * 模拟
     * @param board 棋盘
     * @return 吃掉棋子的最大数量
     */
    public int numRookCaptures(char[][] board) {
        int ans = 0;
        int rookX = 0,rookY = 0;
        // 找到rook的位置
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookX = i;
                    rookY = j;
                    break;
                }
            }
        }

        // 上边
        for (int i = rookX-1; i >= 0; i--) {
            if (board[i][rookY] == 'B') break;
            if (board[i][rookY] == 'p') {
                ans++;
                break;
            }
        }
        // 下边
        for (int i = rookX+1; i < 8; i++) {
            if (board[i][rookY] == 'B') break;
            if (board[i][rookY] == 'p') {
                ans++;
                break;
            }
        }
        // 左边
        for (int i = rookY-1; i >= 0; i--) {
            if (board[rookX][i] == 'B') break;
            if (board[rookX][i] == 'p') {
                ans++;
                break;
            }
        }
        // 右边
        for (int i = rookY+1; i < 8; i++) {
            if (board[rookX][i] == 'B') break;
            if (board[rookX][i] == 'p') {
                ans++;
                break;
            }
        }

        return ans;
    }
}
