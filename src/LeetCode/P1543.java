package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 面试题57 - II. 和为s的连续正数序列
 */
public class P1543 {
    /**
     * 暴力枚举
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target == 1 || target == 2) return new int[][]{};
        ArrayList<Integer[]> temp = new ArrayList<>();
        int half = target/2;
        int sum;

        for (int i = 1; i <= half; i++) {
            for (int j = i+1; j <=half+1; j++) {
               sum = (i+j)*(j-i+1)/2;
               if (sum > target) break;
               if (sum == target) {
                   Integer[] integers = new Integer[j-i+1];
                   for (int k = 0; k < integers.length; k++) integers[k] = i+k;
                   temp.add(integers);
               }
            }
        }
        int[][] ans = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = new int[temp.get(i).length];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = temp.get(i)[j];
            }
        }
        return ans;
    }

    public int[][] findContinuousSequence2(int target) {
        if (target == 1 || target == 2) return new int[][]{};
        int half = target/2;
        int[][] ans = new int[half][];
        int sum,index = 0;

        for (int i = 1; i <= half; i++) {
            for (int j = i+1; j <=half+1; j++) {
                sum = (i+j)*(j-i+1)/2;
                if (sum > target) break;
                if (sum == target) {
                    ans[index] = new int[j-i+1];
                    for (int k = 0; k < ans[index].length; k++) ans[index][k] = i+k;
                    index++;
                }
            }
        }

        return Arrays.copyOf(ans,index);
    }

    public static void main(String[] args) {
        P1543 h = new P1543();
//        int target = 9;
        int target = 15;
        int[][] ans = h.findContinuousSequence(target);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
