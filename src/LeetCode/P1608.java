package LeetCode;

import java.util.Arrays;

/**
 * 面试题56 - 1.数组中数字出现的次数LCOF
 */
public class P1608 {

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) return nums;

        int[] ans = new int[2];
        Arrays.sort(nums);

        int index = 0;
        Integer prev = null;
        for (int i = 0; i < nums.length && index != 2; i++) {
            if (prev == null) prev = nums[i];
            else {
                if (nums[i] != prev) {
                    ans[index++] = prev;
                    prev = nums[i];
                }
                else prev = null;
            }
        }
        if (index != 2) ans[index++] = prev;
        return ans;
    }

    /**
     * 异或分组
     * @param nums
     * @return
     */
    public int[] singleNumbers_Solution2(int[] nums) {
        int[] ans = new int[2];
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }

        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        for (int i : nums) {
            if ((div & i) == 0) ans[0] ^= i;
            else ans[1] ^= i;
        }

        return ans;
    }

    /**
     * 异或分组
     * 优化：res&(-res)等到最低为的1
     * @param nums
     * @return
     */
    public int[] singleNumbers_Solution3(int[] nums) {
        int res = 0;

        for (int i : nums) {
            res ^= i;
        }

        int div = res & (-res);
        int ans = 0;
        for (int i : nums) {
            if ((div & i) == 0) ans ^= i;
        }

        return new int[] {ans,res^ans};
    }
}
