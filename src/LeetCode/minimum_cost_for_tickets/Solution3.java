package LeetCode.minimum_cost_for_tickets;

public class Solution3 {

    /**
     * 动态规划 二分查找
     * @param days 旅行日期
     * @param costs 花费方案
     * @return 最下花费
     */
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        dp[days[0]] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        int first,second,third;
        for (int i = 1; i < days.length; i++) {
            first = binarySearch(days,0,i-1,days[i]-1);
            if (days[i] - 7 < 0 ) second = 0;
            else second = binarySearch(days,0,i-1,days[i] - 7);
            if (days[i] - 30 < 0 ) third = 0;
            else third = binarySearch(days,0,i-1,days[i] - 30);

            dp[days[i]] = Math.min(dp[first]+costs[0],Math.min(dp[second]+costs[1],dp[third]+costs[2]));
        }
        return dp[days[n-1]];
    }

    private int binarySearch(int[] days,int left,int right,int target) {
        if (days[right] <= target) return days[right];
        if (days[left] > target) return target;
        if (days[left] == target) return days[left];

        int mid;
        while (left <= right) {
            mid = (left+right)/2;
            if (days[mid] == target) return target;
            else if (days[mid] < target) {
                if (mid+1 < days.length && days[mid+1] >= target) {
                    if (days[mid+1] == target) return days[mid+1];
                    return days[mid];
                }
                left = mid+1;
            }
            else {
                if (mid-1 >= 0 && days[mid-1] <= target) return days[mid-1];
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution3 h = new Solution3();

//        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
//        int[] costs = {3,13,45};

        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(h.mincostTickets(days,costs));
    }
}
