package HDU;

import java.util.Scanner;

/**
 * 水题
 */
public class P1008 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n,total,pre,cur;

        while ((n = cin.nextInt()) != 0) {
            total = 0;
            pre = 0;
            for (int i = 0; i < n; i++) {
                cur = cin.nextInt();
                if (cur > pre) total += (cur-pre)*6 +5;
                else total += (pre - cur)*4+5;
                pre = cur;
            }
            System.out.println(total);
        }
    }
}
