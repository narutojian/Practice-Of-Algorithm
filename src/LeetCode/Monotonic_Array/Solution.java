package LeetCode.Monotonic_Array;

/**
 * 896. Monotonic Array
 */
public class Solution {

    /**
     * 遍历
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        int preState = 0;
        int curState;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1])
                curState = 1;
            else if (A[i] == A[i-1])
                curState = 0;
            else curState = -1;
            if (curState*preState == -1)
                return false;
            if (preState == 0 && curState != 0) {
                preState = curState;
            }
        }
        return true;
    }
}
