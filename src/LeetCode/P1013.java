package LeetCode;

public class P1013 {

    /**
     * 暴力枚举
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int firstSum = 0,secondSum,totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }
        for (int i = 0; i < A.length - 2; i++) {
            if (i == 0) firstSum = A[i];
            else firstSum += A[i];
            secondSum = A[i+1];
            for (int j = i+2; j < A.length; j++) {
                if (j != i+2) secondSum += A[j-1];
                if (firstSum == secondSum && secondSum == totalSum - firstSum - secondSum) return true;
            }
        }
        return false;
    }
}
