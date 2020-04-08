package LeetCode.problem1531;

/**
 * 面试题13.机器人的运动范围
 */
public class P1531 {
    private int ans = 0;

    /**
     * 用dfs解题
     * @param m 行数
     * @param n 列数
     * @param k 拦截的值
     * @return 可走的方格数
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        dfs(0,0,m,n,k,visit);
        return ans;
    }

    private void dfs(int row, int column, int m, int n, int k, boolean[][] visit) {
        if (row >= m || column >= n) return;
        if (visit[row][column]) return;
        int sum = getSum(row)+getSum(column);
        if (sum > k) return;

        ans ++;
        visit[row][column] = true;
        dfs(row,column+1,m,n,k,visit);
        dfs(row+1,column,m,n,k,visit);
    }

    private int getSum(int a) {
        int ans = 0;
        while (a != 0) {
            ans += a%10;
            a /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        P1531 h = new P1531();
        int m = 11,n = 8,k = 16;
        System.out.println(h.movingCount(m,n,k));
    }
}
