package LeetCode.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /**
     * 优化 空间复杂度从O(n) => O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int curVal;
        for (int i = 0; i < n; i++) {
//            curVal = nums[i]%n;
//            nums[(curVal-1+n)%n] += n;// 如果 nums[i] == n 或是n的倍数 则此时curVal为0
            curVal = (nums[i]-1)%n;
            nums[curVal] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > n)
                continue;
            res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.println(solution2.findDisappearedNumbers(nums));
    }
}
