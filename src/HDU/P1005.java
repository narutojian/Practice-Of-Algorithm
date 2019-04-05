package HDU;

import java.util.Scanner;

/**
 * 矩阵快速模幂
 * 矩阵表达式：
 * 结果矩阵    转移矩阵
 * f(n)   =   A  B  *  f(n-1)
 * f(n-1)     1  0     f(n-2)
 *
 * 递归 到达 f(2),f(1)，转移矩阵的(n-2)次方。
 */
public class P1005 {

    final int m = 7;
    int a,b,n;
    int[][] matA,matB;

    public void Init(){
        matA = new int[][]{
                {a%7, b%7},
                {1, 0}
        };
    }

    /*
    矩阵相乘，三重循环，i表示第一个矩阵的行，j表示第一个矩阵的列，也是第二个矩阵的行，
    k表示第二个矩阵的列
     */
    public int[][] MatMultiply(int[][] matA, int[][] matB){
        int[][] ans = new int[matA.length][matB[0].length];
        int i,j,k;

        for (i = 0;i<matA.length;i++)
            for (j = 0;j<matA[0].length;j++)
                for (k = 0;k<matB[0].length;k++)
                    ans[i][k] = (ans[i][k]+matA[i][j]*matB[j][k])%m;

        return ans;
    }

    /*
    快速幂
     */
    public int QuickMod(int n){

        matB = new int[][]{
                {1,0},
                {0,1}
        };
        int temp;

        while (n > 0){

            temp = n&1;

            if (temp == 1)
                matB = MatMultiply(matA,matB);
            n >>= 1;
            matA = MatMultiply(matA,matA);
        }

        return (matB[0][0]+matB[0][1])%m;
    }

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        P1005 h = new P1005();

        while ((h.a = cin.nextInt()) != 0 && (h.b = cin.nextInt()) !=0 && (h.n = cin.nextInt()) !=0){

            if (h.n == 1 || h.n == 2){
                System.out.println(1);
                continue;
            }

            h.Init();
            System.out.println(h.QuickMod(h.n-2));
        }
        cin.close();
    }
}
