package Fudan.第三题;

public class Solution {

    public int sumEqualE(int[] nums,int E) {
        return getOperations(nums,0,E);
    }

    private int getOperations(int[] nums,int i,int E) {
        if (E == 0 && i == nums.length)
            return 1;
        if (E != 0 && i == nums.length)
            return 0;
        return getOperations(nums,i+1,E-nums[i])+getOperations(nums,i+1,E+nums[i]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {1,1,1,1,1};
//        int E = 3;

//        int[] nums = {1,2,1,1,1};
//        int E = 3;

        int[] nums = {1,2,2,1,1};
        int E = 3;

        System.out.println(solution.sumEqualE(nums,E));
    }
}
