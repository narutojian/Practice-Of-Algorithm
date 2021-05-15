package PAT.A.P1001;

import java.util.Scanner;

/**
 * 1001 A+B Format (20 point(s))
 */
public class Main {

    public String add(int a,int b) {
        int sum = a+b;
        StringBuilder res = new StringBuilder(""+Math.abs(sum));
        int index = res.length()-3;
        while (index > 0) {
            res.insert(index,',');
            index -= 3;
        }
        if (Integer.signum(sum) < 0) {
            res.insert(0,'-');
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner cin = new Scanner(System.in);

        while (cin.hasNextInt()) {
            int a = cin.nextInt();
            int b = cin.nextInt();

            System.out.println(main.add(a,b));
        }
    }
}
