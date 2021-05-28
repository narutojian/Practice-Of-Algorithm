package LeetCode.Integer_to_Roman;

/**
 * 12. Integer to Roman
 */
public class Solution {

    /**
     * 模拟
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] signs = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

        StringBuilder sb = new StringBuilder();

        for (int i = value.length-1; i > -1 && num > 0; i--) {
            int temp = num/value[i];
            for (int j = 0; j < temp; j++) {
                sb.append(signs[i]);
            }
            num -= temp*value[i];
        }
        return sb.toString();
    }
}
