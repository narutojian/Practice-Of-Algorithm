package LeetCode;

/**
 * 双指针
 */
public class P27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0,j = nums.length - 1;
        int length = nums.length;

        while (i <= j) {
            if (nums[i] == val) {
                while (j >= 0 && nums[j] == val) {
                    j--;
                    length--;
                }
                if (i< j) {
                    nums[i] = nums[j--];
                    length--;
                }
            }
            i++;
        }
        return length;
    }
}
