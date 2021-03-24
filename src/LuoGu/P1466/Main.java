package LuoGu.P1466;

import java.util.Arrays;
import java.util.Scanner;

/**
 * P1466 [USACO2.2]集合 Subset Sums
 */
public class Main {

    /**
     * dp 递归 记忆化
     * @param n
     * @return
     */
    public long subSetNum(int n) {
        int total = 0;
        for (int i = 1; i < n + 1; i++) {
            total += i;
        }
        if (total %2 == 1)
            return 0;
        long[][] memo = new long[n+1][total/2+1];// dp[i][j] : 用前i个物品能凑齐j的方案数
        for (long[] row : memo) {
            Arrays.fill(row,-1);
        }
        return getNum(n,total/2,n,memo)>>1;
    }

    private long getNum(int i,int target,int n,long[][] memo) {
        if (target == 0)
            return 1;
        if (i == 0)
            return 0;
        if (memo[i][target] != -1)
            return memo[i][target];
        if (target-i < 0)
            memo[i][target] = getNum(i-1,target,n,memo);
        else memo[i][target] = getNum(i-1,target,n,memo)+getNum(i-1,target-i,n,memo);
        return memo[i][target];
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(main.subSetNum(n));
        }
    }
}
