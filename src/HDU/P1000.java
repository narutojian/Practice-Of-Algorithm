package HDU;

import java.util.Scanner;

/**
 * 用Scanner扫描器来判断是否还有输入。
 */
public class P1000 {

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        while (cin.hasNext())
            System.out.println(cin.nextInt()+cin.nextInt());

        cin.close();
    }
}
