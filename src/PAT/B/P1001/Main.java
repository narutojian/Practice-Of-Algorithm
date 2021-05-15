package PAT.B.P1001;

import java.util.Scanner;

/**
 * 1001 害死人不偿命的(3n+1)猜想
 */
public class Main {

    /**
     * 定义 对给定n的划分步骤数
     * @param n
     * @return
     */
    public int getStep(int n) {
        if (n == 1)
            return 0;
        if (n%2 == 0)
            return 1+getStep(n/2);
        else return 1+getStep((3*n+1)/2);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNext()) {
            n = sc.nextInt();
            System.out.println(main.getStep(n));
        }
    }
}
