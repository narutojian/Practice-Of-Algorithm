package LeetCode.ZigZag_Conversion;

/**
 * 6. ZigZag Conversion
 */
public class Solution {

    /**
     * 数学 找规律
     * 对于第i行的字符,i从1开始
     * 则有两个字符在s中的索引值差距为 2*(numRows-i)，然后为 2*(i-1)，在然后为2*(numRows-1)，。。。
     * 特别的在第1行和最后一行，只有一个值的差距
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int[] gap = new int[2];
        for (int i = 1; i <= numRows; i++) {
            gap[0] = 2*(numRows-i);
            gap[1] = 2*(i-1);
            if (i == 1)
                gap[1] = gap[0];
            else if (i == numRows)
                gap[0] = gap[1];
            int start = i-1;
            int choice = 0;
            while (start < s.length()) {
                sb.append(s.charAt(start));
                start += gap[(choice%2)];
                choice++;
            }
        }
        return sb.toString();
    }
}
