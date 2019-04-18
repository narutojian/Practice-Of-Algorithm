package HDU;

import java.util.Scanner;

/**
 *用一个数组a来存放阶乘每一位的值，然后在从后往前输出。
 *cost time: 3759ms
 *
 */
public class P1042 {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        int n,i,j,s,l;//s作为中间值，l为此时的位数
        int[] a = new int[37000];

        while (cin.hasNext()){

            n = cin.nextInt();
            l = 0;//一开始位数为0
            a[0] = 1;//0！为1

            for (i = 1;i<=n;i++){//从1到n进行累乘

                s = 0;
                //从个位到第(l+1)位与i进行乘积，每一次相乘得出的结果的末位为当前位的值,其余为进位。
                for (j = 0;j<=l;j++){

                    s += a[j]*i;//s保存乘积得出的结果
                    a[j] = s%10;//求出j位上的值
                    s /= 10;//除10作为下一个的进位
                }
                //最后得出的进位往后放
                while ( s != 0){
                    l++;
                    a[l] = s%10;
                    s /= 10;
                }
            }
            for (i = l;i>=0;i--)
                System.out.print(a[i]);
            System.out.println();
        }

        cin.close();
    }
}
