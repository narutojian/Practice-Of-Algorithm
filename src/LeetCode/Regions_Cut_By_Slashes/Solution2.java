package LeetCode.Regions_Cut_By_Slashes;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    int[] fa;

    /**
     * 官方题解做法
     * 将每个方格划分为4个三角形 每个三角形代表一个点
     * 从而通过“/” “\” " " 三种划分方式进行合并点
     * 最终极大连通子图的个数就是区域的个数
     * 该方法有理有据
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        fa = new int[4*n*n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        int fir,sec,thr,fou;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                fir = i*n*4+j*4;
                sec = fir+1;
                thr = sec+1;
                fou = thr+1;
                if (j != 0) {
                    // 不是第一列的三角形 左边的2与当前的0合并
                    union(i*n*4+(j-1)*4+2,fir);
                }
                if (i != 0) {
                    // 不是第一行的三角形 上边的3与当前的1合并
                    union((i-1)*n*4+j*4+3,sec);
                }
                if (grid[i].charAt(j) == ' ') {
                    union(fir,sec);
                    union(fir,thr);
                    union(fir,fou);
                }
                else if (grid[i].charAt(j) == '/') {
                    union(fir,sec);
                    union(thr,fou);
                }
                else {
                    union(sec,thr);
                    union(fir,fou);
                }
            }
        }

        Set<Integer> set = new HashSet<>();// 统计极大连通子图的个数
//        for (int i = 0; i < fa.length; i++) {
//            if (fa[i] != fa[fa[i]])
//                find(i);
//            set.add(fa[i]);
//        }
        // 此时只要找出i == parent[i]的节点就行 这样的节点一定是根节点
        for (int i = 0; i < fa.length; i++) {
            if (i == fa[i])
                set.add(fa[i]);
        }

        return set.size();
    }

    private int find(int i) {
        if (fa[i] != i) {
            fa[i] = find(fa[i]);
        }
        return fa[i];
    }

    private void union(int x,int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;
        fa[rootY] = rootX;
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

//        String[] grid = {" /", "/ "};

//        String[] grid = {"/"};

//        String[] grid = {" /","  "};

//        String[] grid = {"\\/","/\\"};

        String[] grid = {"/\\","\\/"};

//        String[] grid = {"//","/ "};

        System.out.println(solution2.regionsBySlashes(grid));
    }
}
