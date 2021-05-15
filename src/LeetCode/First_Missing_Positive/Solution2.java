package LeetCode.First_Missing_Positive;

public class Solution2 {

    /**
     * 哈希+空间优化
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        // 将负数变为n+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = nums.length+1;
        }
        // 将在[1,n]之间的正数标记为负数
        // 将nums作为哈希表 下标为i的数为负数时表示(i+1)的正数存在
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.abs(nums[i]);
            if (temp <= nums.length && nums[temp-1] > 0)
                nums[temp-1] = -nums[temp-1];
        }
        // 找出第一个大于0的数,该数的下标加一即为缺失的最小正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        // test1
//        int[] nums = {1,2,0};
        //test2
//        int[] nums = {3,4,-1,1};
        //test3
        int[] nums = {7,8,9,11,12};

        System.out.println(solution2.firstMissingPositive(nums));
    }
}
