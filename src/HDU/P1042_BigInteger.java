package HDU;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * P1042的第二种解决方案
 * 用大整数来存储每次求解的结果
 * cost time：655ms
 */
public class P1042_BigInteger {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        int n;
        BigInteger bigInteger;
        while (cin.hasNext()){

            n = cin.nextInt();
            bigInteger = new BigInteger("1");

            for (int i = 2;i<=n;i++)
                bigInteger = bigInteger.multiply(new BigInteger(""+i));

            System.out.println(bigInteger);
        }

        cin.close();
    }

}
