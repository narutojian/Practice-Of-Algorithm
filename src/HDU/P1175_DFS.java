package HDU;

import java.util.Scanner;

public class P1175_DFS {

    int n,m,q,state = 2,amount = 0,endX,endY;
    int[][] map = new int[1000][1000];
    boolean[][] visit = new boolean[1000][1000];
    int[] moveX = {-1,1,0,0};//x轴移动
    int[] moveY = {0,0,-1,1};//y轴移动
    int[] turn = {1,1,0,0};//标记此时所处的方向，0为水平方向，1为垂直方向

    public boolean CheckXY(int x, int y){

        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        else {
            if (x == endX && y == endY)
                return true;
            else if (map[x][y] != 0)
                return false;
        }
        return true;
    }

    public boolean DFS(int x1,int y1,int x2,int y2){

        int i,nextX,nextY,temp;
        visit[x1][y1] = true;

        if (amount >2) return false;
        if (amount == 2 && x1 != x2 && y1 != y2) return false;
        if (x1 == x2 && y1 == y2) return true;

        for (i = 0;i<4;i++){

            nextX = x1 + moveX[i];
            nextY = y1 + moveY[i];

            if (CheckXY(nextX,nextY) && !visit[nextX][nextY]){

                temp = state;

                if (state == 2)
                    state = turn[i];
                else{

                    if (state != turn[i]) {
                        amount++;
                        state = turn[i];
                    }
                }

                if (DFS(nextX,nextY,x2,y2))
                    return true;
                else {
                    if (temp == 2)
                        state = temp;
                    else {
                        if (temp != state){
                            amount--;
                            state = temp;
                        }
                    }

                    visit[nextX][nextY] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        P1175_DFS h = new P1175_DFS();
        int i,j,k,x1,y1,x2,y2;

        while ((h.n = cin.nextInt()) != 0 && (h.m = cin.nextInt()) != 0){

            for (i = 0;i<h.n;i++)
                for (j = 0;j<h.m;j++)
                    h.map[i][j] = cin.nextInt();

            h.q = cin.nextInt();
            for (i = 0;i<h.q;i++){
             x1 = cin.nextInt() -1;
             y1 = cin.nextInt() -1;
             x2 = cin.nextInt() -1;
             y2 = cin.nextInt() -1;

             h.endX = x2;
             h.endY = y2;

             if (h.map[x1][y1] + h.map[x2][y2] != 0 && h.map[x1][y1] == h.map[x2][y2] && h.DFS(x1,y1,x2,y2))
                 System.out.println("YES");
             else System.out.println("NO");

             h.amount =0;
             h.state =2;

             for (j = 0;j<h.n;j++)
                 for (k = 0;k<h.m;k++){
                     if (h.visit[j][k])
                         h.visit[j][k] = false;
                 }
            }
        }

        cin.close();
    }
}
