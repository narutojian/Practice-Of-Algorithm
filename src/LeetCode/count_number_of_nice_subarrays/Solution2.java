package LeetCode.count_number_of_nice_subarrays;

public class Solution2 {

    /**
     * 数学
     * @param nums 数组
     * @param k 奇数的个数
     * @return 子数组个数
     */
    public int numberOfSubarrays(int[] nums, int k) {
//        List<Integer> oddList = new ArrayList<>();
//        List<Integer> gap = new ArrayList<>();
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] & 1) == 1) {
//                oddList.add(i);
//                if (oddList.size() == 1) gap.add(i+1);
//                else gap.add(oddList.get(oddList.size()-1) - oddList.get(oddList.size()-2));
//            }
//        }
//        if (oddList.size() != 0) {
//            gap.add(nums.length - oddList.get(oddList.size()-1));
//        }
//
//        int front,end;
//        for (int i = 0; i < oddList.size()-k+1; i++) {
//            ans += gap.get(i)*gap.get(i+k);
//        }
//        return ans;
        int[] odd = new int[nums.length+2];
        int pos = 1,ans = 0;
        odd[0] = -1;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odd[pos++] = i;
            }
        }
        odd[pos++] = nums.length;

        for (int i = 1; i < pos-k; i++) {
            ans += (odd[i]-odd[i-1])*(odd[i+k] - odd[i+k-1]);
        }
        return ans;
    }
}
