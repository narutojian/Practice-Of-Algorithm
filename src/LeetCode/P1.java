package LeetCode;

import java.util.HashMap;

public class P1 {

    /**
     * 哈希存储的优化，只需要在遍历数组的时候，判断map中是否存在对应的值，
     * 如果存在，那就返回，不存在，则将这一对键值对存储在map中。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){

        HashMap<Integer,Integer> map = new HashMap<>();
        int a;

        for (int i = 0; i < nums.length; i++) {
            a = target - nums[i];

            if (map.containsKey(a))
                return new int[]{map.get(a),i};
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException();
    }

//    /**
//     * 采用哈希存储，将索引和值对应起来。
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] twoSum(int[] nums, int target) {
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int a;
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//
//            a = target - nums[i];
//            if (map.containsKey(a) && map.get(a) != i)
//                return new int[]{i,map.get(a)};
//        }
//        throw new IllegalArgumentException();
//    }

//    /**
//     * brute force solution
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] twoSum(int[] nums, int target) {
//        int a;
//        for (int i = 0; i < nums.length-1; i++) {
//            a = target - nums[i];
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[j] == a)
//                    return new int[]{i,j};
//            }
//        }
//
//        throw new IllegalArgumentException();
//    }

    public static void main(String[] args) {

        int[] nums = {3,3};
        int target = 6;

        int[] res = new P1().twoSum(nums,target);

        for (int i :
                res) {
            System.out.println(res[i]);
        }
    }
}
