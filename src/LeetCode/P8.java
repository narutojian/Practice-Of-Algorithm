package LeetCode;

public class P8 {
    public int myAtoi(String str) {
        String mutiRegx = "[0-9+-]";
        String regxOfNumber = "[0-9]";
        String regxOfSign = "[+-]";
        final int max = Integer.MAX_VALUE/10;
        final int maxMod = Integer.MAX_VALUE%10;
        boolean sign = false;
        int ans = 0;
        char c,num = 0;
        int diffValue,i = 0;

        str = str.trim();

        if (str.length() == 0)
            return 0;
        if (!(""+str.charAt(0)).matches(mutiRegx))
            return 0;
        if ((""+str.charAt(0)).matches(regxOfSign)){
            if (str.charAt(0) == '-')
                sign = true;
            i = 1;
        }


        for (; i < str.length(); i++) {
            c = str.charAt(i);
            if ((""+c).matches(regxOfNumber)){
                diffValue = c - '0';

                if (sign){
                    if (ans > max || ( ans == max && diffValue >= maxMod+1))
                        return Integer.MIN_VALUE;
                }
                else {
                    if (ans > max || (ans == max && diffValue >= maxMod))
                        return Integer.MAX_VALUE;
                }

                ans = ans*10 + diffValue;
            }
            else break;
        }

        if (sign)
            ans *= -1;
        return ans;
    }

    public static void main(String[] args) {

//        String s = "4193 with words";
//        String s = "words and 987";
//        String s = "-91283472332";
//        String s = "";
//        String s = "  ";
        String s = "+-2";
//        String s = "+-ab";
//        String s = "+-2abc";
//        String s = "  0000000000012345678";
//        String s = "-2147483648";
        System.out.println(new P8().myAtoi(s));
    }
}
