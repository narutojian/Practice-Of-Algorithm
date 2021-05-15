package PAT.B.P1011;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 1011 A+B 和 C
 */
public class Main {

    public boolean isGreater(int a,int b,int c) {
        return (long)a+b > c;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNext()) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                System.out.println("Case #"+(i+1)+": "+main.isGreater(a,b,c));
            }
        }
    }
}
