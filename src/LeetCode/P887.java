package LeetCode;

public class P887 {

    /**
     * 动态规划
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        int min,max;
        // 初始化
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                min = Integer.MAX_VALUE;
                for (int x = 1;x <= j; x++) {
                   max = Math.max(dp[i][j-x],dp[i-1][x-1]);
                   if (max < min) min = max;
                }
                dp[i][j] = 1+min;
            }
        }

        return dp[K][N];
    }

    /**
     * 动态规划+二分搜索法
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop_Solutions(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        int left,right,mid,t1,t2;
        // 初始化
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                left = 1;
                right = j;
                while (left+1 < right) {
                    mid = (left+right)/2;
                    t1 = dp[i-1][mid-1];
                    t2 = dp[i][j-mid];
                    if (t1 > t2) right = mid;
                    else if (t1 < t2) left = mid;
                    else right = left = mid;
                }
                dp[i][j] = 1 + Math.min(Math.max(dp[i-1][left-1],dp[i][j-left]),Math.max(dp[i-1][right-1],dp[i][j-right]));
            }
        }

        return dp[K][N];
    }

    public static void main(String[] args) {
        P887 h = new P887();
//        int k = 2, n = 6;
        int k = 9, n = 5000;
        System.out.println(h.superEggDrop(k,n));
    }
}
