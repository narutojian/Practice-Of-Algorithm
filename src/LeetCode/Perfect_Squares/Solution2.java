package LeetCode.Perfect_Squares;

public class Solution2 {
    private int res = Integer.MAX_VALUE;

    /**
     * 贪心
     * @param n
     * @return
     */
    public int numSquares(int n) {
        minNum(n,0);
        return res;
    }

    private void minNum(int n,int operation) {
        if (operation >= res)
            return;
        if (n == 0) {
            res = Math.min(res,operation);
            return;
        }
        if (n == 1) {
            res = Math.min(res,operation+1);
            return;
        }

        for (int i = (int) Math.floor(Math.sqrt(n)); i > 0; i--) {
            int cur = i*i;
            minNum(n-cur,operation+1);
        }
    }
}
