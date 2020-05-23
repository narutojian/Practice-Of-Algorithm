package LeetCode.coin_lcci;

/**
 * 面试题 08.11. 硬币
 */
public class Solution2 {
    final int val = 1000000007;

    /**
     * 暴力 数学 枚举 超时
     * @param n 输入
     * @return 方案数
     */
    public int waysToChange(int n) {
        int ans = 0;
        int first,second,third,firstVal,secondVal;
        first = n/25;

        for (int i = 0; i <= first; i++) {
            firstVal = n - i*25;
            second = firstVal/10;
            for (int j = 0; j <= second; j++) {
                secondVal = firstVal - j*10;
                third = secondVal/5;
                ans += third+1;
            }
            ans %= val;
        }
        return ans;
    }

    /**
     * 数学解法 等差数列
     * @param n 输入
     * @return 方案数
     */
    public int waysToChange_Solution2(int n) {
        int ans = 0,total = n/5;
        long m,k;

        for (int i = 0; i <= total; i += 5) {
            m = total-i;
            k = m/2;
            ans += ((k+1)%val * (m-k+1)%val)%val;
            ans %= val;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        int n = 1000000;
//        System.out.println(h.waysToChange(n));
        System.out.println(h.waysToChange_Solution2(n));
    }
}
