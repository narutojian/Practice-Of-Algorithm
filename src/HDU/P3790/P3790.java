package HDU.P3790;

import java.util.Scanner;

/**
 * 邻接矩阵的dijkstra算法.
 * hdu上超时，看讨论上说是输入问题，我看其他语言提交的就可以
 */
public class P3790 {
    int n,m;
    int[][] dis = new int[1001][1001];
    int[][] pay = new int[1001][1001];
    boolean[] visit = new boolean[1001];
    int[] ansOfDis = new int[1001];
    int[] ansOfPay = new int[1001];

    public void Init() {
        for (int i = 1; i <= n; i++) {
            visit[i] = false;
            ansOfDis[i] = Integer.MAX_VALUE;
            ansOfPay[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                dis[i][j] = -1;
                pay[i][j] = -1;
            }
        }
    }

    public void Dijkstra(int start,int end) {
        visit[start] = true;
        for (int i = 1; i <= n; i++) {
            if (dis[start][i] != -1) {
                ansOfDis[i] = dis[start][i];
                ansOfPay[i] = pay[start][i];
            }
        }

        int minDis,tempOfDis,tempOfPay;
        while (start != end) {
            minDis = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && ansOfDis[i] < minDis) {
                    minDis = ansOfDis[i];
                    start = i;
                }
            }

            visit[start] = true;
            if (start == end) return;

            for (int i = 1; i <= n; i++) {
                if (!visit[i] && dis[start][i] != -1) {
                    tempOfDis = ansOfDis[start] + dis[start][i];
                    if (tempOfDis < ansOfDis[i]) {
                        ansOfDis[i] = tempOfDis;
                        ansOfPay[i] = ansOfPay[start] + pay[start][i];
                    }
                    else if (tempOfDis == ansOfDis[i]) {
                        tempOfPay = ansOfPay[start]+pay[start][i];
                        if (tempOfPay < ansOfPay[i])
                            ansOfPay[i] = tempOfPay;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        P3790 p = new P3790();
        int n,m,s,t,x1,x2,pay,dis;

        while ((n = cin.nextInt()) != 0 && (m = cin.nextInt()) != 0) {
            p.n = n;
            p.m = m;
            p.Init();
            for (int i = 0; i < m; i++) {
                x1 = cin.nextInt();
                x2 = cin.nextInt();
                dis = cin.nextInt();
                pay = cin.nextInt();
                p.dis[x1][x2] = dis;
                p.pay[x1][x2] = pay;
                p.dis[x2][x1] = dis;
                p.pay[x2][x1] = pay;
            }
            s = cin.nextInt();
            t = cin.nextInt();
            p.Dijkstra(s,t);
            System.out.println(p.ansOfDis[t]+" "+p.ansOfPay[t]);
        }
    }
}
