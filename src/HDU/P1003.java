package HDU;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 动态规划思想
 * dp[i]为遍历到第i个数值时的最大值序列和
 * dp[i] = max{dp[i-1]+a[i], a[i]}
 *
 * 对于第i个数值时，如果此时的 a[i] > a[i]+dp[i-1]（dp[i-1]<0）,
 * 就意味着到第i个数值的序列之和的最大值小于第i个数值本身
 * 所以此时 dp[i] = a[i]；
 *
 * 否则：dp[i] = dp[i-1]+a[i];
 *
 * 我们要求的是最大的子序列之和，所以只要每次与当前的dp[i]进行比较，然后记录最大值即可。
 */
public class P1003 {

    public static void main(String[] args){

        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        int t = cin.nextInt(),n,x,count = 0,i,maxValue,s,e,start,end;
        int[] dp = new int[100001];

        while (t-- >0){

            count++;
            n = cin.nextInt();
            maxValue = -1001;
            s = e = 1;
            start = end = 1;
            for (i = 1;i<=n;i++){
                x = cin.nextInt();

                if (x > dp[i-1]+x){
                    dp[i] = x;
                    s = e = i;
                }
                else {
                    dp[i] = dp[i-1]+x;
                    e = i;
                }

                if (dp[i] > maxValue) {
                    maxValue = dp[i];
                    start = s;
                    end = e;
                }
            }

            System.out.println("Case "+count+":");
            System.out.println(maxValue+" "+start+" "+end);

            if (t != 0)
                System.out.println();
        }
        cin.close();
    }
}
