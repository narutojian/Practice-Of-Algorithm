package LeetCode.Maximum_Points_You_Can_Obtain_from_Cards;

public class Solution2 {
    /**
     * 滑动窗口 双指针
     * 逆向求解 要求最大 那么可以反过来求最小
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowsLen = n-k;
        int minScore = Integer.MAX_VALUE;// 窗口大小为windowsLen的最小的分数和
        int totalScore = 0;// 总分数

        for (int i = 0; i < n; i++) {
            totalScore += cardPoints[i];
        }
        int left = -1;
        int right = 0;
        int curSum = 0;
        for (; right < cardPoints.length; right++) {
            curSum += cardPoints[right];
            if ((right-left) > windowsLen) {
                left++;
                curSum -= cardPoints[left];
            }
            if ((right-left) == windowsLen)
                minScore = Math.min(minScore,curSum);
        }
        return totalScore-minScore;
    }
}
