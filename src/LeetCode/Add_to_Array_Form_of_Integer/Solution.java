package LeetCode.Add_to_Array_Form_of_Integer;

import java.util.LinkedList;
import java.util.List;

/**
 * 989. Add to Array-Form of Integer
 */
public class Solution {

    /**
     * 逐位相加
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length-1;
        int digit,carry = 0,sum;
        List<Integer> res = new LinkedList<>();
        while (K != 0) {
            digit = K%10;
            if (i > -1) {
                sum = digit+A[i]+carry;
                i--;
            }
            else sum = digit+carry;

            digit = sum%10;
            carry = sum/10;

            res.add(0,digit);
            K /= 10;
        }
        for (;i > -1;i--) {
            sum = A[i]+carry;
            carry = sum/10;
            res.add(0,sum%10);
        }
        if (carry != 0) {
            res.add(0,carry);
        }
        return res;
    }
}
