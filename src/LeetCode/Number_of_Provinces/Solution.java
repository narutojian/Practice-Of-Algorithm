package LeetCode.Number_of_Provinces;

/**
 * 547. Number of Provinces
 */
public class Solution {

    /**
     * dfs 邻接矩阵
     * 找出所有极大连通图
     * 时间复杂度 O(|v|^2) 空间复杂度 O(|v|)
     *
     * 官方题解中还有bfs、并查集的解法
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        // 访问标记数组
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i,n,visited,isConnected);
            ans++;
        }
        return ans;
    }

    /**
     * DFS 将在同一个连通图的点全部找出并将其访问状态置true
     * @param start
     * @param visited
     * @param isConnected
     */
    void dfs(int start,int n,boolean[] visited,int[][] isConnected) {
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (isConnected[start][i] == 1)
                dfs(i,n,visited,isConnected);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        int[][] isConnected = {
//                {1,1,0},
//                {1,1,0},
//                {0,0,1}
//        };
        // test2
        int[][] isConnected = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        int ans = solution.findCircleNum(isConnected);
        System.out.println(ans);
    }
}
