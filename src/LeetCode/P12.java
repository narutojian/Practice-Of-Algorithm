package LeetCode;

/**
 * 建立一个罗马字符串与数字的映射表,然后按顺序找对应的罗马字符串就行
 */
public class P12 {

    public String intToRoman(int num) {
        String[] roman= {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] romanNum = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder ans = new StringBuilder();
        int temp;

        for (int i = roman.length-1; i >= 0; i--) {
            temp = num / romanNum[i];
            num -= temp*romanNum[i];
            for (int j = 0; j < temp; j++)
                ans.append(roman[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        int num = 3;
//        int num = 4;
//        int num = 9;
        int num = 58;
//        int num = 1994;

        System.out.println(new P12().intToRoman(num));
    }
}
