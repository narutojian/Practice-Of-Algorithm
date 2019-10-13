package LeetCode;

public class P9 {

    /**
     * solution 1:
     * 将整数x转为字符串，然后一次循环，将字符串的前面和后面进行比较
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = ""+x;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(length-i-1))
                return false;
        }
        return true;
    }

    /**
     * solution 2:
     * 首先特判整数小于0的一定不是回文数，
     * 然后在正数的情况下，把每个字母都拿出来放到一个int型的数组里，然后让前面和后面开始比较。
     * @param x
     * @return
     */
    public boolean isPalindrome_2(int x) {

        if (x < 0)
            return false;

        int[] num = new int[10];
        int index = 0;
        while (x != 0) {
            num[index++] = x%10;
            x /= 10;
        }

        for (int i = 0; i < index; i++) {
            if (num[i] != num[index-i-1])
                return false;
        }
        return true;
    }

    /**
     * solution 3:
     * 首先特判x为负数则不为回文数，
     * 然后每次取x的末尾的数字，然后将末尾的数字重新构成一个整数，只不过相比较于x这个整数的每个位上的数字是倒序，
     * 然后比较x与这个整数是否相同
     * @param x
     * @return
     */
    public boolean isPalindrome_3(int x) {
        if (x < 0)
            return false;
        int temp = 0,x1 = x;

        while (x != 0) {
            temp = temp*10 + x%10;
            x /= 10;
        }

        return temp == x1;
    }

    public static void main(String[] args) {

//        int x = 121;
//        int x = -121;
        int x = 10;
//        System.out.println(new P9().isPalindrome(x));
//        System.out.println(new P9().isPalindrome_2(x));
        System.out.println(new P9().isPalindrome_3(x));
    }
}
