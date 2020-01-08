package LeetCode;

import java.util.*;

/**
 * 有重复数字序列的全排列
 * 相对于没有重复数字的全排列，这个需要加上几个判断来删除那些重复的结果
 *
 * 这个还可以对其中去掉已经交换过一次的数字对的判断进行优化，比如用邻接表进行存储数字对
 */
public class P47 {
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 依旧是使用回溯的做法，但是加了两个判断：
     * 1.如果要交换的两个数字是相同的，那么交换没有意义，此时可以跳过当前交换的数字，直到遇到一个可以交换的数字
     * 2. 曾经交换过的一对数字，在当前未排列的序列当中，不可以再次交换，再次交换没有意义，而且重复
     * @param ans
     * @param nums
     * @param start
     */
    public void fullPermuteUnique(List<List<Integer>> ans,int[] nums,int start) {
        if (start == nums.length -1) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }

        Set<List<Integer>> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (i == start) {
                fullPermuteUnique(ans,nums,start+1);
            }
            else {
                //去掉相同数字的交换和已经交换过的一对数字
                while (i < nums.length) {
                    if (nums[i] == nums[start] || set.contains(Arrays.asList(nums[i],nums[start]))) {
                        i++;
                    }
                    else break;
                }
                if (i == nums.length) return;
                //添加已经交换的一对数字到集合中
                set.add(Arrays.asList(nums[i],nums[start]));
                set.add(Arrays.asList(nums[start],nums[i]));
                swap(nums,i,start);
                fullPermuteUnique(ans,nums,start+1);
                swap(nums,i,start);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        fullPermuteUnique(ans,nums,0);
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,2,1,1};
//        int[] nums = new int[] {1,2,3};
        int[] nums = new int[] {-1,2,-1,2,1,-1,2,1};
        P47 h = new P47();
        List<List<Integer>> ans = h.permuteUnique(nums);
        for (List<Integer> i :
                ans) {
            System.out.println(i.toString());
        }
    }
}
