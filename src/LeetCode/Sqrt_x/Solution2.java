package LeetCode.Sqrt_x;

public class Solution2 {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int maxVal = (int) Math.pow(Integer.MAX_VALUE,0.5);
        int high = maxVal;
        int low = 0;
        int mid;

        while (low <= high) {
            mid = low+(high-low)/2;
            int cur = mid*mid;
            if (cur == x)
                low = mid+1;
            else if (cur < x)
                low = mid+1;
            else if (cur > x)
                high = mid-1;
        }
        return low == 0 ? low : low-1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int x = 4;

        System.out.println(solution2.mySqrt(x));
    }
}
