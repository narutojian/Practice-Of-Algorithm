package LeetCode;

public class P29 {

    /**
     * 用long来存储除数和被除数
     * 执行效率低 731ms
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (divisor == 1) return dividend;

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        if (b > a) return 0;

        int ans,index = 1;
        long curValue = b;

        while (curValue < a) {
            index += index;
            curValue = curValue << 1;
        }
        if (curValue == a)
            ans = index;
        else {
            while (curValue > a) {
                curValue -= b;
                index--;
            }
            ans = index;
        }
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            return -ans;
        return ans;
    }

    /**
     * 用int存储数据，移位操作来进行乘除
     * 执行效率高 1ms
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide_2(int dividend, int divisor) {
        //如果除数为1，返回被除数
        if (divisor == 1) return dividend;
        //特判溢出的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        //如果除数为-1，返回被除数的相反数
        if (divisor == -1) return -dividend;

        boolean sign = false,odd = false;//sign 符号位，true为两数符号不一致；odd 奇偶性，true为奇数
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = true;
        // 将除数和被除数都变为负数
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        // 如果除数小于被除数，那说明商为0
        if (divisor < dividend) return 0;
        // 如果商为1的情况，其中divisor+divisor > 0 表明溢出了，说明两倍的divisor一定小于-2^31
        if (divisor == dividend || divisor+divisor < dividend || divisor+divisor > 0) return sign ? -1 : 1;
        // 判断奇偶
        int temp = -dividend & 1;
        if (temp == 1) {
            odd = true;
            dividend ++;
        }
        temp = divisor;
        int ans,pre = -1,cur = 1;// pre为区间的左边界，cur为右边界

        dividend = dividend >> 1;// 除2
        // 确定右边界
        while (divisor > dividend) {
            pre = cur;
            cur = cur << 1;
            divisor = divisor << 1;
        }
        int preValue = divisor >> 1;
        int mid,midValue,diff;
        // 二分查找
        while (true) {
            // 如果左边界的值与被除数相等 或者 右边界与左边界相差1时，此时左边界就是结果
            if (preValue == dividend || cur-pre == 1) {
                ans = pre;
                diff = dividend - preValue;// 保存下余数
                break;
            }
            // 右边界的值与被除数相等
            if (divisor == dividend) {
                ans = cur;
                diff = dividend - divisor;
                break;
            }
            //取中值
            mid = pre + ((cur - pre) >> 1);
            midValue = preValue + ((divisor-preValue) >> 1);
            if (midValue >= dividend) {
                pre = mid;
                preValue = midValue;
            }
            else {
                cur = mid;
                divisor = midValue;
            }
        }
        diff <<= 1;// 余数乘2
        ans <<= 1;
        if (odd) diff--;
        if (diff < temp) ans++;
        if (sign) return -ans;
        return ans;
    }

    public static void main(String[] args) {
//        int dividend = 10;
//        int divisor = 3;
//        int dividend = 7;
//        int divisor = -3;
//        int dividend = Integer.MAX_VALUE;
//        int divisor = 1;
//        int dividend = Integer.MIN_VALUE;
//        int divisor = -1;
//        int dividend = Integer.MIN_VALUE;
//        int divisor = 2;
//        int dividend = Integer.MIN_VALUE;
//        int divisor = 3;
//        int dividend = Integer.MAX_VALUE;
//        int divisor = 2;
//        int dividend = 2;
//        int divisor = -2;
//        int dividend = 3;
//        int divisor = -2;
//        int dividend = 4;
//        int divisor = -2;
//        int dividend = 1100540749;
//        int divisor = -1090366779;
//        P29 h = new P29();
//        System.out.println(h.divide(dividend,divisor));
//        System.out.println(h.divide_2(dividend,divisor));
        System.out.println(Integer.MIN_VALUE << 1);
    }
}
