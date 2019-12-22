package HDU.P3790;

import java.util.Scanner;

/**
 * 邻接表的dijkstra算法。
 * 依旧超时
 */
public class P3790_Solution2 {
    int n;
    int m;
    Vertex[] vertices = new Vertex[1001];
    int[] dis = new int[1001];
    int[] cost = new int[1001];

    private class Vertex {
        Edge firstEdge;
    }

    private class Edge {
        int to;
        int dis;
        int cost;
        Edge next;
    }

    public void init() {
        for (int i = 1; i <= n; i++) {
            vertices[i] = new Vertex();
            vertices[i].firstEdge = null;
        }
    }

    public void buildGraph(int start,int end,int dis,int cost) {
        Edge edge = new Edge();
        edge.to = end;
        edge.dis = dis;
        edge.cost = cost;

        Edge firstEdge = vertices[start].firstEdge;

        if (firstEdge == null) {
            vertices[start].firstEdge = edge;
        }
        else {
            while (firstEdge.next != null) {
                firstEdge = firstEdge.next;
            }
            firstEdge.next = edge;
        }
    }

    public void dijkstra(int start,int end) {
        boolean[] visit = new boolean[n+1];
        int minDis,nextVertex = 0;
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            cost[i] = Integer.MAX_VALUE;
        }

        visit[start] = true;
        Edge temp = vertices[start].firstEdge;
        minDis = Integer.MAX_VALUE;

        // 初始化dis和cost，并确定下一个点是哪个
        while (temp != null) {
            dis[temp.to] = temp.dis;
            cost[temp.to] = temp.cost;
            if (minDis > temp.dis) {
                minDis = temp.dis;
                nextVertex = temp.to;
            }
            temp = temp.next;
        }

        while (nextVertex != end) {
            visit[nextVertex] = true;
            minDis = Integer.MAX_VALUE;
            temp = vertices[nextVertex].firstEdge;
            while (temp != null) {
                if (visit[temp.to]) {
                    temp = temp.next;
                    continue;
                }
                int tempDis = dis[nextVertex] + temp.dis;
                int tempCost = cost[nextVertex] + temp.cost;
                if (tempDis < dis[temp.to]) {
                    dis[temp.to] = tempDis;
                    cost[temp.to] = tempCost;
                }
                else if (tempDis == dis[temp.to]) {
                    if (tempCost < cost[temp.to])
                        cost[temp.to] = tempCost;
                }
                temp = temp.next;
            }
            for (int i = 1; i <=n; i++) {
                if (visit[i]) continue;
                if (minDis > dis[i]) {
                    minDis = dis[i];
                    nextVertex = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        P3790_Solution2 h = new P3790_Solution2();
        Scanner cin = new Scanner(System.in);
        int n,m,a,b,d,p,s,t;

        while ((n = cin.nextInt()) != 0 && (m = cin.nextInt()) != 0) {
            h.n = n;
            h.m = m;
            h.init();
            for (int i = 0; i < m; i++) {
                a = cin.nextInt();
                b = cin.nextInt();
                d = cin.nextInt();
                p = cin.nextInt();
                h.buildGraph(a,b,d,p);
                h.buildGraph(b,a,d,p);
            }
            s = cin.nextInt();
            t = cin.nextInt();
            h.dijkstra(s,t);
            System.out.println(h.dis[t]+" "+h.cost[t]);
        }
    }
}
