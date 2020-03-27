package LeetCode;

import java.util.Arrays;

public class P914 {

    /**
     * 计数+最大公约数
     * @param deck 给定的卡牌数组
     * @return true为可分租，false为不可分组
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        // 对数组排序
        Arrays.sort(deck);
        // 用preDuplicate和curDuplicate来存储前一个重复的值和后一个重复的值
        int start = 0,end = 1,preDuplicate = 0,curDuplicate,temp;
        // 计数+判断是否可以分组
        for (int i = 1; i < deck.length; i++) {
            if (deck[i] == deck[i-1]) end++;
            else {
                if (preDuplicate == 0) preDuplicate = end-start;
                curDuplicate = end-start;
                temp = gcd(Math.max(preDuplicate,curDuplicate),Math.min(preDuplicate,curDuplicate));
                if (temp == 1) return false;
                start = i;
                end = start+1;
                preDuplicate = temp;
            }
        }
        // 如果整个数组只有一种值
        if (preDuplicate == 0) return true;
        // 数组最后一种数值和前一种数值的比较判断
        curDuplicate = end-start;
        return gcd(Math.max(preDuplicate, curDuplicate), Math.min(preDuplicate, curDuplicate)) != 1;
    }

    /**
     * 辗转相除法求最大公约数
     * @param a 正整数
     * @param b 正整数
     * @return 最大公约数
     */
    public int gcd(int a,int b) {
        if (b == 1) return 1;
        int temp;

        while ((temp = a%b) != 0) {
            a = b;
            b = temp;
            if (b == 1) return 1;
        }
        return b;
    }

    public static void main(String[] args) {
        P914 h = new P914();
//        int[] deck = {1,1,1,2,2,2,3,3};
        int[] deck = {1,1,1,1,2,2,2,2,2,2};
        int a = 12, b = 7;
        System.out.println(h.gcd(a,b));
        System.out.println(h.hasGroupsSizeX(deck));
    }
}
