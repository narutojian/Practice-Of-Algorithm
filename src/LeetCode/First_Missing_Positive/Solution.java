package LeetCode.First_Missing_Positive;

public class Solution {

    /**
     * 用一个长度为n的数组来表示哈希
     * 开辟一个数组record用来记录在nums在[1,n]范围的正数
     * 存在的正数标记为1 不存在的为0
     * 最后输出第一个为0的record的下标
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int[] record = new int[nums.length+1];
        for (int i = 1; i < record.length; i++) {
            record[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0)
                record[nums[i]] = 1;
        }
        for (int i = 1; i < record.length; i++) {
            if (record[i] != 1)
                return i;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
        int[] nums = {1,2,0};
        //test2
//        int[] nums = {3,4,-1,1};
        //test3
//        int[] nums = {7,8,9,11,12};

        System.out.println(solution.firstMissingPositive(nums));
    }
}
