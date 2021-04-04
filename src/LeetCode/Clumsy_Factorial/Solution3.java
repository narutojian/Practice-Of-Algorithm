package LeetCode.Clumsy_Factorial;

public class Solution3 {

    /**
     * 模拟 递归优化
     * @param N
     * @return
     */
    public int clumsy(int N) {
        if (N == 1)
            return 1;
        if (N == 2)
            return 2;
        if (N == 3)
            return 6;
        return N*(N-1)/(N-2)+(N-3)+dfs(N-4);
    }

    private int dfs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return -1;
        if (n == 2)
            return -2;
        if (n == 3)
            return -6;
        return -n*(n-1)/(n-2)+(n-3)+dfs(n-4);
    }
}
