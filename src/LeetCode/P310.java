package LeetCode;

import java.util.*;

public class P310 {


    /**
     * 这是第一种解决方案，但是基本上都会超时。
     * 解决方案：
     *      如果整个树只有两个节点，那么这两个节点不管谁做根节点都会是最小高度树。
     *      要想求最小高度树的根节点，那么只要找不是叶子节点且越在中心地带的节点。（可以通过画图看出）
     *
     *      那么怎么找这样的节点呢？
     *          解决思路：
     *              把所有度数为1的节点都删除，且递归下去，即叶子节点删除后，更新剩下的节点的度数。
     *              直到树中只剩下1个或2个节点时，它们就是答案。
     * 第一种方案的思想就是这样，但是该方案在编写时耗费很大的时间，内存占用也很多。
     * 其中，时间主要花在查找度数为1的节点，删除后，更新剩下节点的度数。
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> list = new LinkedList<>();

        //如果树中节点的个数只有1个或2个，那么这些节点就是最小高度树的根节点
        if (n <= 2){
            for (int i = 0; i < n; i++)
                list.add(i);
            return list;
        }

        boolean[][] adj = new boolean[n][n];//邻接矩阵
        int[] inDegrees = new int[n];//每个节点的度数
        boolean[] dead = new boolean[n];//判断节点是否死亡，死亡的意思是指此节点作为根节点不能生成最小高度数
        int[] temp;

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = true;
            adj[edges[i][1]][edges[i][0]] = true;
            inDegrees[edges[i][0]]++;
            inDegrees[edges[i][1]]++;
        }

        for (int i = 0; i < n; i++)
            list.add(i);

        while (list.size() > 2){

            temp = inDegrees.clone();

            for (int i = 0; i < n; i++) {
                if (!dead[i] && temp[i] == 1){
                    dead[i] = true;
                    list.remove((Integer)i);

                    for (int j = 0; j < n; j++) {
                        if (!dead[j] && adj[i][j])
                            inDegrees[j]--;
                    }
                }
            }
        }

        return list;
    }


    /**
     * 这是第二种方案，很快，内存也消耗小。
     * 第二种方案的思想跟第一种方案是一样的，但实现方式很是巧妙。
     *
     * 首先，我在第一种方案种存储邻接表用的是二位数组，第二种方案用的是一维数组。
     * 但一维数组怎么能够实现呢？
     * adj[i]:表示与i相邻的所有节点。
     *
     * 那么怎么存储这个所有节点呢？
     * 用异或的方式存储，数组的初始值都为0.
     * 如果与i相邻的只有一个节点j，那么adj[i] ^ j = j;
     * 如果与i相邻的不只一个节点，那么每一个都与adj[i]异或一次。
     * 那么，当删除掉一个度数为1的节点a时，更新邻接表，即让adj[i]和a异或一次。两次异或，会还原成原本的样子。
     * 比如 1 ^ 2 = 3; 3 ^ 2 = 1; 1代表adj[i],2是与i相邻的节点，那么adj[i]变为3，删除掉2后，adj[i] ^ 3 变为之前的一个状态。
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees_2(int n, int[][] edges){

//        if(n==1) return Collections.singletonList(0);
        if (n <= 2){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(i);
            return list;
        }

        int[] connected = new int[n];// connected[i] 记录与节点i连接的节点
        int[] degree = new int[n];// 记录节点的度数

        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            connected[v1] ^= v2;//通过异或存储所有与之相邻的节点
            connected[v2] ^= v1;

            degree[v1]++;
            degree[v2]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i<degree.length ; i++) {
            if(degree[i] == 1) {
                queue.offer(i);
            }
        }

        while(n > 2 && !queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i<size ; i++) {
                int v = queue.poll();
                n--;
                int v1 = connected[v];// 与节点v相邻的所有节点
                connected[v1] ^= v;
                degree[v1]--;
                if(degree[v1] == 1) {
                    queue.add(v1);
                }
            }
        }

        List<Integer> result = new ArrayList<>(queue);
        return result;
    }

    public static void main(String[] args) {

//        int n = 6;
//        int[][] edges = {{0,3},{1,3},{2,3},{4,3},{5,4}};

        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
//        List<Integer> list = new P310().findMinHeightTrees(n,edges);
        List<Integer> list = new P310().findMinHeightTrees_2(n,edges);
        System.out.println(list);
    }
}
