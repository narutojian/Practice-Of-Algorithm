package HDU;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 大整数相加，直接调用BigInteger类。
 * 格式注意。
 */
public class P1002 {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        int t = cin.nextInt(),count = 0;
        BigInteger a,b;

        while (t -- >0){
            count++;

            a = new BigInteger(""+cin.next());
            b = new BigInteger(""+cin.next());

            System.out.println("Case "+count+":");
            System.out.println(a+" + "+b+" = "+a.add(b));

            if (t != 0)
                System.out.println();
        }
        cin.close();
    }
}
