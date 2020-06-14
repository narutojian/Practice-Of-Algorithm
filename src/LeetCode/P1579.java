package LeetCode;

/**
 * 面试题62. 圆圈中最后剩下的数字
 */
public class P1579 {

    /**
     * 模拟
     * 超时的方法
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        boolean[] visit = new boolean[n];
        int length = n;
        int nextM = m%length;
        int delete = 0;
        while (length != 1) {
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;
                delete++;
                if (delete == nextM) {
                    visit[i] = true;
                    length--;
                    nextM = m%length;
                    delete = 0;
                }
            }
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) return i;
        }
        return n-1;
    }

    /**
     * 动态规划 递推做法
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_Solution2(int n, int m) {
        int[] dp = new int[n+1];
        dp[1] = 0;
//        int order;
        for (int i = 2; i < n + 1; i++) {
//            order = m%i;
//            dp[i] = (order+dp[i-1]) %i;
            dp[i] = (m+dp[i-1]) %i;
        }
        return dp[n];
    }

    /**
     * 动态规划 空间优化
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining_Solution3(int n, int m) {
        if (n == 1) return 0;
        int cur = 0,next;
        for (int i = 2; i < n + 1; i++) {
            next = (m+cur)%i;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        P1579 h = new P1579();
        int n = 10;
        int m = 17;
        System.out.println(h.lastRemaining(n,m));
    }
}
