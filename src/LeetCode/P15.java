package LeetCode;

import java.util.*;

public class P15 {

    /**
     * 自己一开始的做法，核心是想让时间复杂度变为O(n^2)，但实现的并不好
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer,Integer> mapOfNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mapOfNums.containsKey(nums[i]))
                mapOfNums.put(nums[i],1);
            else mapOfNums.put(nums[i],mapOfNums.get(nums[i])+1);
        }
        Integer[] key = mapOfNums.keySet().toArray(new Integer[mapOfNums.keySet().size()]);


        List<Integer> temp;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                int third = -(key[i]+key[j]);
                if (!mapOfNums.containsKey(third)) continue;
                else {
                    if (i == j && key[i] == third) {
                        if (mapOfNums.get(key[i]) < 3) continue;
                    }
                    else if (i == j) {
                        if (mapOfNums.get(key[i]) < 2) continue;
                    }
                    else if (key[i] == third) {
                        if (mapOfNums.get(key[i]) < 2) continue;
                    }
                    else if (key[j] == third) {
                        if (mapOfNums.get(key[j]) < 2) continue;
                    }
                }
                temp = new ArrayList<>();
                temp.add(key[i]);
                temp.add(key[j]);
                temp.add(third);
                Collections.sort(temp);
                set.add(temp);
            }
        }

        for (List<Integer> i :
                set) {
            ans.add(i);
        }
        return ans;
    }

    /**
     * 看力扣里大佬的解析，用的是排序+双指针做法。自愧不如。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_Solution2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int k = 0,i,j,s;
        for (; k < nums.length-2; k++) {
            if (nums[k] > 0) break;
            if (k != 0 && nums[k] == nums[k-1]) continue;
            i = k+1;
            j = nums.length-1;
            while (i < j) {
                s = nums[k]+nums[i]+nums[j];
                if ( s == 0) {
                    ans.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    i++;
                    j--;
                    while (j > k && nums[j] == nums[j+1]) j--;
                    while (i < nums.length && nums[i] == nums[i-1]) i++;
                }
                else if (s > 0) j--;
                else i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0,0};
//        int[] nums = {1,1,-2};
//        int[] nums = {-2,-3,0,0,-2};
//        int[] nums = {-2,0,0,2,2};
//        System.out.println(new P15().threeSum(nums));
        System.out.println(new P15().threeSum_Solution2(nums));
    }
}
