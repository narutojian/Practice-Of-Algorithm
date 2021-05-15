package LeetCode.Pascal_Triangle_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */
public class Solution {
    /**
     * 模拟 递推
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Arrays.asList(1);
        if (rowIndex == 1) return Arrays.asList(1,1);

        ArrayList<Integer> res = new ArrayList<>(rowIndex+1);
        res.add(1);
        res.add(1);
        int curRow = 2;
        for (; curRow < rowIndex+1; curRow++) {
            int pre = 1;
            int cur;
            for (int i = 1; i < curRow; i++) {
                cur = res.get(i);
                res.set(i,cur+pre);
                pre = cur;
            }
            res.add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int rowIndex = 5;
        System.out.println(solution.getRow(rowIndex));
    }
}
