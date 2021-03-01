package LeetCode.Range_Sum_Query_Immutable;

/**
 * 303. Range Sum Query - Immutable
 */
public class NumArray {
    // 前缀和
    int n;
    int[] prefix;

    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0)
            return;
        prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return prefix[j];
        }
        return prefix[j]-prefix[i-1];
    }
}
