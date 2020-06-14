package LeetCode.Leetcode2020春季个人赛;

public class P1 {

    public int minCount(int[] coins) {
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += coins[i]/2;
            if (coins[i]%2 != 0) ans++;
        }
        return ans;
    }
}
