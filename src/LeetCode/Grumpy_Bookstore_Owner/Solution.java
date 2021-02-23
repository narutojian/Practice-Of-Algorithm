package LeetCode.Grumpy_Bookstore_Owner;

/**
 * 1052. Grumpy Bookstore Owner
 */
public class Solution {

    /**
     * 滑动窗口
     * 窗口长度固定为X 找出使用抑制技能的起始点
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int limitSum = 0,sum = 0,diff = 0,maxIndex = 0;
        while (right < n) {
            sum += customers[right];
            if (grumpy[right] == 0)
                limitSum += customers[right];

            if (right-left+1 > X) {
                sum -= customers[left];
                if (grumpy[left] == 0) {
                    limitSum -= customers[left];
                }
                left++;
            }

            if (right-left+1 == X) {
                if (diff < (sum-limitSum)) {
                    diff = sum-limitSum;
                    maxIndex = left;
                }
            }
            right++;
        }
        for (int i = maxIndex; i < maxIndex+X; i++) {
            grumpy[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;

        System.out.println(solution.maxSatisfied(customers,grumpy,X));
    }
}
