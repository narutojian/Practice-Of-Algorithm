package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思想还是用的三数之和的思想，双指针+排序
 * 只不过因为规模变大，所以变为固定两个数，然后再用双指针法
 */
public class P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        Arrays.sort(nums);
        int i,j,first=0,second,sum;

        while (first < nums.length-3) {
            if (nums[first] >= 0 && nums[first] > target) break;
            while (first != 0 && first < nums.length-3 && nums[first] == nums[first-1]) first++;

            for (second = first+1;second < nums.length-2;second++) {
                if (nums[second] >= 0 && nums[first]+nums[second] > target) break;
                while (second != first+1 && second < nums.length-2 && nums[second] == nums[second-1]) second++;

                i = second+1;
                j = nums.length-1;
                while (i < j) {
                    sum = nums[first]+nums[second]+nums[i]+nums[j];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[first],nums[second],nums[i],nums[j]));
                        i++;
                        j--;
                        while (i < j && nums[i-1] == nums[i]) i++;
                        while (j > i && nums[j+1] == nums[j]) j--;
                    }
                    else if (sum > target) j--;
                    else i++;
                }
            }
            first++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;
//        int[] nums = {-7,-5,0,7,1,1,-10,-2,7,7,-2,-6,0,-10,-5,7,-8,5};
//        int target = 28;
//        int[] nums = {1,-2,-5,-4,-3,3,3,5};
//        int target = -11;
//        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
//        int target = -9;
        int[] nums = {6,0,-8,-8,6,-1,6,5,3,0,3,5};
        int target = -2;
        System.out.println(new P18().fourSum(nums,target));
    }
}
