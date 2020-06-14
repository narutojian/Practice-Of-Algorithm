package LeetCode.problem11;

public class P11_Solution2 {

    /**
     * 暴力 枚举
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0,temp;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                temp = (j-i)*Math.min(height[i],height[j]);
                if (temp > ans) ans = temp;
            }
        }
        return ans;
    }

    /**
     * 双指针 优化
     * @param height
     * @return
     */
    public int maxArea_Solution2(int[] height) {
        int res = 0;
        int low = 0, high = height.length - 1,minValue,temp;
        minValue = Math.min(height[low],height[high]);
        res = (high-low) * minValue;
        while (low != high) {

            if (height[low] <= height[high])
                low++;
            else high--;
            temp = Math.min(height[low],height[high]);
            if (minValue >= temp) continue;
            minValue = temp;
            res = Math.max(res,(high-low)*minValue);
        }
        return res;
    }
}
