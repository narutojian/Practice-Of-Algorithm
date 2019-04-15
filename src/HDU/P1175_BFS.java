package HDU;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1175_BFS {

    int n, m, q,nextX, nextY;
    int[][] map = new int[1000][999];
    int[][] minTurn = new int[1000][999];
    int[] moveX = {-1, 1, 0, 0};//x轴移动
    int[] moveY = {0, 0, -1, 1};//y轴移动
    int[] turn = {1, 1, 0, 0};//标记此时所处的方向，0为水平方向，1为垂直方向
    Queue<Node1175BFS> queue = new LinkedList<>();
    Node1175BFS start = new Node1175BFS();
    Node1175BFS end = new Node1175BFS();
    Node1175BFS node,next;

    public void Init(){

        int i,j;
        for (i = 0;i<n;i++)
            for (j = 0;j<m;j++)
                minTurn[i][j] = 3;
    }

    public boolean CheckNode(int x, int y) {

        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        else {
            if (x == end.x && y == end.y)
                return true;
            else if (map[x][y] != 0)
                return false;
        }
        return true;
    }

    public boolean BFS() {

        int i;
        start.state = 2;
        queue.offer(start);

        while (!queue.isEmpty()) {

            node = queue.poll();
//            System.out.println(node.x + " "+node.y);

            for (i = 0; i < 4; i++) {
                nextX = node.x + moveX[i];
                nextY = node.y + moveY[i];

                if (CheckNode(nextX, nextY)) {
                    next = new Node1175BFS();
                    next.x = nextX;
                    next.y = nextY;
                    next.state = turn[i];

                    if (node.state != 2) {
                        if (node.state != next.state)
                            next.amount = node.amount + 1;
                        else next.amount = node.amount;
                    }

                    if (next.amount > 2) continue;
                    if (next.amount == 2 && nextX != end.x && nextY != end.y) continue;
                    if (next.x == end.x && next.y == end.y) return true;
                    if (next.amount <= minTurn[nextX][nextY]) {
                        minTurn[nextX][nextY] = next.amount;
                        queue.offer(next);
//                        System.out.print(nextX+" "+nextY+"  ");
                    }
                }
            }
//            System.out.println("\r\n");
        }

        return false;
    }

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);
        P1175_BFS h = new P1175_BFS();
        int i,j;

        while ((h.n = cin.nextInt()) != 0 && (h.m = cin.nextInt()) != 0){

            for (i = 0;i<h.n;i++)
                for (j = 0;j<h.m;j++)
                    h.map[i][j] = cin.nextInt();

            h.q = cin.nextInt();

            for (i = 0;i<h.q;i++){

                h.Init();
                h.start.x = cin.nextInt() -1;
                h.start.y = cin.nextInt() -1;
                h.start.amount = 0;
                h.end.x = cin.nextInt() -1;
                h.end.y = cin.nextInt() -1;
                h.end.amount = 0;
                if (h.map[h.start.x][h.start.y] + h.map[h.end.x][h.end.y] != 0 && h.map[h.start.x][h.start.y] == h.map[h.end.x][h.end.y] && h.BFS())
                    System.out.println("YES");
                else System.out.println("NO");

                h.queue.clear();
            }
        }

        cin.close();
    }
}

class Node1175BFS {

    int x;
    int y;
    int amount;
    int state;
}