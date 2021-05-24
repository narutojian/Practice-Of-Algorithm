package LeetCode.Palindrome_Number;

/**
 * 9. Palindrome Number
 */
public class Solution {

    /**
     * 数学
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int max = Integer.MAX_VALUE/10;
        int maxNum = Integer.MAX_VALUE%10;
        int reverse = 0; // 计算反转x后的值
        int temp = x;
        while (temp != 0) {
            int num = temp%10;
            if (reverse > max || (reverse == max && num > maxNum))
                return false;
            reverse = reverse * 10 + num;
            temp /= 10;
        }
        if (x == reverse)
            return true;
        return false;
    }
}
