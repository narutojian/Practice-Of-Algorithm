package HDU;

import java.util.Scanner;

/**
 * 公式：n*(n+1)/2
 * 如果n为偶数，sum =n/2 *(n+1)
 * 如果n为奇数，sum =(n+1)/2 * n
 *
 * n*(n+1)可能会超出32位的最大长度,所以要先除2.
 */
public class P1001 {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        int n,sum,temp;

        while (cin.hasNext()){

            n = cin.nextInt();
            temp = n&1;
            if(temp == 1)
                sum = (n+1)/2 *n;
            else sum = n/2 *(n+1);

            System.out.println(sum+"\n\r");
        }

        cin.close();
    }
}
