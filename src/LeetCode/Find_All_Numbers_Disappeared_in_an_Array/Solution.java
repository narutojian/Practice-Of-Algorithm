package LeetCode.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */
public class Solution {
    /**
     * 哈希 计数
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] existed = new boolean[n+1];// existed[i] == true 表明值为i的数存在

        for (int i = 0; i < n; i++) {
            existed[nums[i]] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (!existed[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
