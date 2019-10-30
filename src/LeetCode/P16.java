package LeetCode;

import java.util.Arrays;

public class P16 {
    /**
     * 和P15同样的做法
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Integer ans = null;
        int k = 0,i,j,s;
        Arrays.sort(nums);

        for (;k < nums.length-2;k++) {
            if (k != 0 && nums[k] == nums[k-1]) continue;

            i = k+1;
            j = nums.length - 1;
            while (i < j) {
                s = nums[k]+nums[i]+nums[j];
                if (ans == null) ans = s;
                if (s < target)
                    i++;
                else if (s == target) return s;
                else j--;
                if (Math.abs(target-ans) > Math.abs(target - s)) ans = s;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
//        int target = 1;
        int[] nums = {1,1,1,1};
        int target = 0;
        System.out.println(new P16().threeSumClosest(nums,target));
    }
}
