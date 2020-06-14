package LeetCode;

public class P69 {

    public int mySqrt(int x) {
        Double ans = Math.sqrt(x);
        return Integer.parseInt(ans.toString().split("[.]")[0]);
    }

    public int mySqrt_2(int x) {
        int left = 1, right = 46340;

        if (x == 0) return 0;
        if (x >= right * right) return right;

        int mid, temp, next, pre;
        while (left <= right) {
            mid = (left + right) / 2;
            temp = mid * mid;
            if (temp == x) return mid;
            else if (temp < x) {
                next = (mid + 1) * (mid + 1);
                if (next == x) return mid + 1;
                if (next > x) return mid;
                left = mid + 1;
            } else {
                pre = (mid - 1) * (mid - 1);
                if (pre <= x) return mid - 1;
                right = mid - 1;
            }
        }
        return left;
    }


    // 参考自liliwei的代码
    public int mySqrt_3(int x) {
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static void main(String[] args) {
        P69 h = new P69();
        int x = 1024;

        System.out.println(h.mySqrt(x));
    }
}
