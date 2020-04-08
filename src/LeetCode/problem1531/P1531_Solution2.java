package LeetCode.problem1531;

public class P1531_Solution2 {
    /**
     * 递推
     * @param m 行数
     * @param n 列数
     * @param k 拦截的值
     * @return 可走的方格数
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        int ans = 1;
        visit[0][0] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] || getSum(i)+getSum(j) > k) continue;
                if (i-1 >= 0 && visit[i-1][j]) visit[i][j] = true;
                if (j-1 >= 0 && visit[i][j-1]) visit[i][j] = true;
                ans += visit[i][j] ? 1 : 0;
            }
        }

        return ans;
    }

    /**
     * 计算一个数的每一位的数字之和
     * @param a 给定的数
     * @return 结果
     */
    private int getSum(int a) {
        int ans = 0;
        while (a != 0) {
            ans += a%10;
            a /= 10;
        }
        return ans;
    }
}
