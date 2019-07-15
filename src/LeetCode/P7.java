package LeetCode;

public class P7 {

    /**
     * 想先把数据x转成字符串，然后用java字符串自带的字符串反转函数反转字符串，然后再将字符串转成int型
     * @param x
     * @return
     */
    public int reverse(int x) {

        if (x < 10 && x > -10)
            return x;

        long temp = x;
        boolean isNegative = false;

        if (x < 0)
            isNegative = true;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Math.abs(temp));
        stringBuilder.reverse();

        if (isNegative)
            stringBuilder.insert(0,'-');
        temp = Long.parseLong(stringBuilder.toString());

        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
            return 0;
        return (int) temp;
    }

    public static void main(String[] args) {

        int x = -2147483648;

        System.out.println(new P7().reverse(x));

    }
}
