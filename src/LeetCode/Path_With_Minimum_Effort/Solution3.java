package LeetCode.Path_With_Minimum_Effort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {
    int[] fa;
    int[] rank;

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length; // 行
        int cols = heights[0].length; // 列
        int ans = 0;

        PriorityQueue<Edges> queue = new PriorityQueue<>(new Comparator<Edges>() {
            @Override
            public int compare(Edges o1, Edges o2) {
                return o1.height - o2.height;
            }
        });
        // 将所有的边加入队列中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curIndex = i*cols+j;
                // 右边的边
                if (j != cols-1) {
                    queue.add(new Edges(curIndex,curIndex+1,Math.abs(heights[i][j]-heights[i][j+1])));
                }
                // 上边的边
                if (i != 0) {
                    queue.add(new Edges(curIndex,(i-1)*cols+j,Math.abs(heights[i][j]-heights[i-1][j])));
                }
            }
        }

        // 建立并查集
        makeSet(rows*cols);
        while (!queue.isEmpty()) {
            Edges curEdge = queue.remove();
            ans = Math.max(ans,curEdge.height);
            union(curEdge.from,curEdge.to);
            if (find(0) == find(fa.length-1)) return ans;
        }

        return ans;
    }

    /**
     * 初始化
     * @param n 节点的个数
     */
    private void makeSet(int n) {
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    /**
     * 查询指定节点的根节点
     * @param x 节点
     * @return 返回节点x的根节点
     */
    private int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }

    /**
     * 合并节点x对应的树与节点y对应的树
     * @param x 节点x
     * @param y 节点y
     */
    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootY] = rootX;
            rank[rootX]++;
        }
        else fa[rootY] = rootX;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

//        int[][] heights = {
//                {1,2,2},
//                {3,8,2},
//                {5,3,5}
//        };

//        int[][] heights = {
//                {1,2,3},
//                {3,8,4},
//                {5,3,5}
//        };


//        int[][] heights = {
//                {1,2,1,1,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,2,1,2,1},
//                {1,1,1,2,1}
//        };

//        int[][] heights = {
//                {10,8},
//                {10,8},
//                {1,2},
//                {10,3},
//                {1,3},
//                {6,3},
//                {5,2}
//        };

        int[][] heights = {
                {1,1000000}
        };

        System.out.println(solution3.minimumEffortPath(heights));
    }
}
