package LeetCode.single_number;

/**
 * 136. Single Number
 */
public class Solution {

    /**
     * 位运算 异或找出唯一一个不同的数
     * @param nums 数组序列
     * @return 返回唯一一个不同的数
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
