package LeetCode.Most_Stones_Removed_with_Same_Row_or_Column;

/**
 * 947. Most Stones Removed with Same Row or Column
 */
public class Solution {
    /**
     * dfs 找出所有的极大连通子图
     * 一个极大连通子图删除到最后只剩下一个石头
     * 所有最终结果为 n-(连通子图的个数)
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int count = 0;// 记录连通子图的个数

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i,n,visited,stones);
            count++;
        }

        return n-count;
    }

    /**
     * DFS
     * @param start
     * @param n
     * @param visited
     * @param stones
     */
    private void dfs(int start,int n,boolean[] visited,int[][] stones) {
        int x = stones[start][0];
        int y = stones[start][1];
        // 这边需要从0开始；若从start+1开始的话，会遗漏连接的点
        // 相应的 时间复杂度上升
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (x == stones[i][0] || y == stones[i][1]) {
                visited[i] = true;
                dfs(i,n,visited,stones);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] stones = {
//                {0,0},
//                {0,1},
//                {1,0},
//                {1,2},
//                {2,1},
//                {2,2}
//        };

//        int[][] stones = {
//                {0,0},
//                {0,2},
//                {1,1},
//                {2,0},
//                {2,2}
//        };

//        int[][] stones = {
//                {0,0}
//        };

        int[][] stones = {
                {0,1},
                {1,0},
                {1,1}
        };

        System.out.println(solution.removeStones(stones));
    }
}