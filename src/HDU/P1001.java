package HDU;

import java.util.Scanner;

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
