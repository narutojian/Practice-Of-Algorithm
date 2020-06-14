package LeetCode;

public class P300 {
    int ans = Integer.MIN_VALUE;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        getMaxLength(0,nums);
        return ans == Integer.MIN_VALUE ? 1 : ans;
    }

    private int getMaxLength(int start, int[] nums) {
        for ( ; start < nums.length-1; start++) {
            if (nums[start] < nums[start+1])
                break;
        }
        if (start == nums.length-1) return 1;

        int index = 0;
        int[] lists = new int[nums.length - start];
        lists[index++] = nums[start++];
        for (;start < nums.length;start++) {
            if (nums[start] > lists[index-1]) {
                lists[index++] = nums[start];
                ans = Math.max(ans,index);
            }
            else if (nums[start] < lists[index-1]) {
                if (nums[start] > lists[index-2])
                    lists[index-1] = nums[start];
                else {
                    int temp = index-3;
                    while (temp >= 0 && nums[start] <= lists[temp]) temp--;
                    temp++;
                    if (temp+nums.length-start > ans)
                        ans = Math.max(ans,temp+getMaxLength(start,nums));
                }
            }
            if (ans >= index+nums.length-start) break;
        }
        return index;
    }

    public static void main(String[] args) {
        P300 h = new P300();
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {10,9,2,5,3,7,3,10,2,9};
//        int[] nums = {10,9,2,5,3,7,2,10,1,9};
//        int[] nums = {10,9,2,5,3,7,3,10,4,8,9};
        System.out.println(h.lengthOfLIS(nums));
    }
}
