package LeetCode.Most_Stones_Removed_with_Same_Row_or_Column;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    int[] fa;// fa[i]: 表示i节点的父节点的索引号 该索引号与stones的索引号一致 表示第i个stone
    int[] rank;// 树的深度
    Map<Integer,Integer> xMap = new HashMap<>();// 记录已有的x轴的值，以及该行对应的节点索引号
    Map<Integer,Integer> yMap = new HashMap<>();// 记录已有的y轴的值，以及该列对应的节点索引号

    // 初始化并查集
    private void makeSet(int n) {
        fa = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    /**
     * 查找i节点的父节点
     * @param i
     * @return
     */
    private int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    /**
     * 合并一个石头的x轴坐标对应的连通子图与y轴坐标对应的连通子图
     * @param x
     * @param y
     * @return 返回当前合并后的父节点索引号
     */
    private int unionSet(int x,int y) {
        int indexX = xMap.get(x);// x对应的节点序号
        int indexY = yMap.get(y);// y对应的节点序号
        int rootX = find(indexX);
        int rootY = find(indexY);
        if (rootX == rootY) return rootX;
        if (rank[rootX] < rank[rootY]) {
            fa[rootX] = rootY;
            return rootY;
        }
        else if (rank[rootX] == rank[rootY]) {
            fa[rootX] = rootY;
            rank[rootY]++;
            return rootY;
        }
        else {
            fa[rootY] = rootX;
            return rootX;
        }
    }

    public int removeStones(int[][] stones) {
        int faNum = 0;// 父节点的数量
        int n = stones.length;
        makeSet(n);

        int x,y;
        // 初始化xMap,yMap
        for (int i = 0; i < n; i++) {
            x = stones[i][0];
            y = stones[i][1];
            if (!xMap.containsKey(x)) {
                xMap.put(x,i);
            }
            if (!yMap.containsKey(y)) {
                yMap.put(y,i);
            }
        }
        for (int i = 0; i < n; i++) {
            x = stones[i][0];
            y = stones[i][1];
            // 该节点的父节点即为合并后返回的父节点索引号
            fa[i] = unionSet(x,y);
        }
        // 记录父节点数
        Map<Integer,Boolean> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!count.containsKey(find(i))) {
                count.put(fa[i],true);
            }
        }
        return n-count.size();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

                int[][] stones = {
                {0,0},
                {0,1},
                {1,0},
                {1,2},
                {2,1},
                {2,2}
        };

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

//        int[][] stones = {
//                {0,1},
//                {1,0},
//                {1,1}
//        };

        System.out.println(solution2.removeStones(stones));
    }
}
