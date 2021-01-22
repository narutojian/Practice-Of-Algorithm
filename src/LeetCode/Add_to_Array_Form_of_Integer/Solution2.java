package LeetCode.Add_to_Array_Form_of_Integer;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    /**
     * 看了其他人的题解 自己动手写下加法模板
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        int i = A.length-1;
        int sum;
        while (i > -1 || K != 0) {
            sum = 0;
            if (i > -1) {
                sum += A[i];
                i--;
            }
            sum += K%10;
            K /= 10;
            if (sum > 9) {
                K++;// 进位加到K上
                sum %= 10;
            }
            res.add(0,sum);
        }

        return res;
    }
}
