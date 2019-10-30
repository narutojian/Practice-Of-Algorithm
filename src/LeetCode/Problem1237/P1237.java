package LeetCode.Problem1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 水题，要利用好customFunction函数的单调递增的特性
 */
public class P1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int temp;
        for (int i = 1; i < 1001; i++) {
            temp = customfunction.f(i,1);
            if (temp == z) {
                ans.add(Arrays.asList(i,1));
                break;
            }
            if (temp > z) break;
            for (int j = 2; j < 1001; j++) {
                if (customfunction.f(i,j) == z) {
                    ans.add(Arrays.asList(i,j));
                    break;
                }
            }
        }
        return ans;
    }
}
