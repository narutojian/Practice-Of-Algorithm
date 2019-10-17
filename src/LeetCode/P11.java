package LeetCode;

/**
 * 题解：
 * 一开始想不明白怎么写，因为这个题目有两个因素影响这个面积。
 * 一个是长度，一个是高度。
 * 然后看到题解的标题上有双指针法，然后才感觉这样可以行。
 */
public class P11 {

    public int maxArea(int[] height) {
        int res;
        int low = 0, high = height.length - 1;
        res = (height.length -1) * Math.min(height[low],height[high]);

        while (low != high) {

            if (height[low] <= height[high])
                low++;
            else high--;

            res = Math.max(res,(high-low)*Math.min(height[low],height[high]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new P11().maxArea(height));
    }
}
