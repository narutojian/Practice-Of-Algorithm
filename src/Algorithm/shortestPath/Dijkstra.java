package Algorithm.shortestPath;

/**
 * Dijkstra算法
 * 例子为有向图
 * 输入
 * n 表示顶点的个数，顶点的编号从0开始
 * edges[m][i,j,w] m为第几条边， i,j为一条边的两个节点，且 i->j,w为这条边的权重(w >= 0)
 * root 表示源点
 *
 * 输出
 * 输出一个一维数组dist,表示root到其他各点最短路径长度
 */
public class Dijkstra {
    private int[] dist;
    private int[] path;

    public int[] shortestPath(int n,int[][]edges,int root ) {
        dist = new int[n]; // 保存最短路径长度
        path = new int[n]; // 保存最短路径
        boolean[] visit = new boolean[n]; // 记录节点是否访问过，访问过代表此点已确定了最短路径
        int[][] adj = new int[n][n]; // 邻接矩阵
        // 初始化邻接矩阵，默认两点之间不相连，值为无穷大，在这里用Integer.MAX_VALUE表示
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.MAX_VALUE;
            }
        }
        // 赋值邻接矩阵
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = edges[i][2];
        }
        // 初始化dist和path
        for (int i = 0; i < n; i++) {
            dist[i] = adj[root][i];
            if (dist[i] != Integer.MAX_VALUE) {
                path[i] = root;
            }
            else path[i] = -1;
        }
        // 将源点标为已访问
        visit[root] = true;
        dist[root] = 0;
        path[root] = root;

        int flag = n-1,curNode = 0,minValue;

        while (flag != 0) {
            // 找出当前dist中路径长度最短的那个点作为下一个点
            minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;
                if (minValue > dist[i]) {
                    minValue = dist[i];
                    curNode = i;
                }
            }
            // 标记找出来的点
            visit[curNode] = true;
            flag--;

            // 通过curNode，更新dist和path
            for (int i = 0; i < n; i++) {
                if (visit[i] || adj[curNode][i] == Integer.MAX_VALUE) continue;
                if (dist[i] > dist[curNode]+adj[curNode][i]) {
                    dist[i] = dist[curNode]+adj[curNode][i];
                    path[i] = curNode;
                }
            }
        }
        return dist;
    }

    /**
     * 递归打印路径
     * @param root 源点
     * @param end 终点
     */
    public void dfs(int root, int end) {
        if (end != root) {
            dfs(root,path[end]);
        }
        System.out.print(end+" ");
    }

    public static void main(String[] args) {
        Dijkstra h = new Dijkstra();

        // 测试
        int n = 7;
        int[][] edges = {{0,1,4},{0,2,6},{0,3,6},{1,2,1},{1,4,7},{2,4,6},{2,5,4},{3,2,2},{3,5,5},{4,6,6},{5,4,1},{5,6,8}};
        int root = 0;

        int[] dist = h.shortestPath(n,edges,0);

        for (int i : dist) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(root+"->"+i+": ");
            h.dfs(root,i);
            System.out.println();
        }
    }
}
