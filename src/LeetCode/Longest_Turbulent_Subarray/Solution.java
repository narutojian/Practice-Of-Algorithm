package LeetCode.Longest_Turbulent_Subarray;

/**
 * 978. Longest Turbulent Subarray
 */
public class Solution {

    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int pre = Integer.MAX_VALUE;
        int cur = 0;
        for (;end < arr.length-1;end++) {
            cur = arr[end]-arr[end+1];
            if (cur == 0) {
                maxLen = Math.max(maxLen,end-start+1);
                start = end+1;
                pre = Integer.MAX_VALUE;
            }
            else if (pre != Integer.MAX_VALUE && Integer.signum(cur)*Integer.signum(pre) > 0) {
                maxLen = Math.max(maxLen,end-start+1);
                start = end;
                pre = cur;
            }
            else pre = cur;
        }
        maxLen = Math.max(maxLen,arr.length-start);

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] arr = {9,4,2,10,7,8,8,1,9};

//        int[] arr = {9,4,2,10,7,8,6,9,7};

//        int[] arr = {4,8,12,16};

//        int[] arr = {100};

//        int[] arr = {9,9};

        int[] arr = {9,9,9};

        System.out.println(solution.maxTurbulenceSize(arr));
    }
}
