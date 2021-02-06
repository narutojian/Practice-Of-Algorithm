package LeetCode.Maximum_Points_You_Can_Obtain_from_Cards;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 */
public class Solution {
    int res = 0;

    /**
     * 回溯 超时
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        dfs(0,0,cardPoints.length-1,cardPoints,k);
        return res;
    }

    private void dfs(int curSum,int left,int right,int[] cardPoints,int k) {
        if (k == 0) {
            res = Math.max(res,curSum);
            return;
        }
        dfs(curSum+cardPoints[left],left+1,right,cardPoints,k-1);
        dfs(curSum+cardPoints[right],left,right-1,cardPoints,k-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] cardPoints = {1,2,3,4,5,6,1};
//        int k = 3;

//        int[] cardPoints = {2,2,2};
//        int k = 2;

//        int[] cardPoints = {9,7,7,9,7,7,9};
//        int k = 7;

//        int[] cardPoints = {1,1000,1};
//        int k = 1;

        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;

        System.out.println(solution.maxScore(cardPoints,k));
    }

}
