package LeetCode.Container_With_Most_Water;

/**
 * 11. Container With Most Water
 */
public class Solution {

    /**
     * 暴力枚举
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int n = height.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                res = Math.max(res,Math.min(height[i],height[j])*(j-i));
            }
        }
        return res;
    }
}
