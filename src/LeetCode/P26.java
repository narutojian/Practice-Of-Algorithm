package LeetCode;

public class P26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <=1) return nums.length;

        int cur = nums[0];
        int startIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) continue;
            cur = nums[i];
            nums[++startIndex] = cur;
        }
        return startIndex+1;
    }
}
