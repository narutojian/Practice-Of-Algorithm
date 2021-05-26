package LeetCode.Container_With_Most_Water;

public class Solution2 {

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = Math.min(height[right],height[left])*(right-left);

        // 每次都移动高度小的那个指针
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            }
            else right--;
            res = Math.max(res,Math.min(height[left],height[right])*(right-left));
        }

        return res;
    }
}
