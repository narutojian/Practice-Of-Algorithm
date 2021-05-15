package LeetCode.Russian_Doll_Envelopes;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 */
public class Solution {

    /**
     * 排序后 暴力枚举 O(n^2)
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        quickSort(envelopes,0,n-1);

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        for (int i = 0; i < n; i++) {
            dp[i] = dfs(i,envelopes,dp);
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            if (res < dp[i])
                res = dp[i];
        }
        return res;
    }

    private int dfs(int start,int[][] envelopes,int[] dp) {
        if (start == 0)
            return 1;
        if (dp[start] != -1)
            return dp[start];
        dp[start] = 1;
        for (int i = start-1; i > -1; i--) {
            if (isGreater(envelopes[start],envelopes[i])) {
                dp[i] = dfs(i,envelopes,dp);
                dp[start] = Math.max(dp[start],1+dp[i]);
            }
        }
        return dp[start];
    }

    private void quickSort(int[][] envelopes,int left,int right) {
        if (left >= right)
            return;
        int[] pivot = envelopes[left];// 基点
        int low = left;
        int high = right;

        while (low < high) {
            while (low < high && envelopes[high][0] > pivot[0])
                high--;
            if (low < high) {
                envelopes[low] = envelopes[high];
                low++;
            }
            while (low < high && pivot[0] > envelopes[low][0])
                low++;
            if (low < high) {
                envelopes[high] = envelopes[low];
                high--;
            }
        }
        envelopes[low] = pivot;

        quickSort(envelopes,left,low-1);
        quickSort(envelopes,low+1,right);
    }

    private boolean isGreater(int[] a,int[] b) {
        if (a[0] > b[0] && a[1] > b[1])
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] envelopes = {
//                {2,100},
//                {3,200},
//                {4,300},
//                {5,500},
//                {5,400},
//                {5,250},
//                {6,370},
//                {6,360},
//                {7,380}
//        };

        int[][] envelopes = {
                {3,5},
                {7,8},
                {3,6},
                {3,10},
                {7,20},
                {17,3},
                {17,45}
        };

        System.out.println(solution.maxEnvelopes(envelopes));
    }
}
