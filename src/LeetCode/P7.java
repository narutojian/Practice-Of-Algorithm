package LeetCode;

public class P7 {

//    /**
//     * 想先把数据x转成字符串，然后用java字符串自带的字符串反转函数反转字符串，然后再将字符串转成int型
//     * @param x
//     * @return
//     */
//    public int reverse(int x) {
//
//        if (x < 10 && x > -10)
//            return x;
//
//        long temp = x;
//        boolean isNegative = false;
//
//        if (x < 0)
//            isNegative = true;
//
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(Math.abs(temp));
//        stringBuilder.reverse();
//
//        if (isNegative)
//            stringBuilder.insert(0,'-');
//        temp = Long.parseLong(stringBuilder.toString());
//
//        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
//            return 0;
//        return (int) temp;
//    }

    /**
     * 参考官网上的解法，用数学取模的方式弹出x的末尾数字，并在加进去时判断是否数据溢出。
     * @param x
     * @return
     */
    public int reverse(int x){

        int rev = 0,pop,max = Integer.MAX_VALUE/10,min = Integer.MIN_VALUE/10;

        while (x != 0){

            pop = x%10;
            x /= 10;

            if (rev > max || (rev == max && pop > 7)) return 0;
            if (rev < min || (rev == min && pop < -8)) return 0;

            rev = rev*10 +pop;
        }

        return rev;
    }

    public static void main(String[] args) {

        int x = -2147483648;

        System.out.println(new P7().reverse(x));

    }
}
