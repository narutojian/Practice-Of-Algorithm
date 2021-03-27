package LeetCode.N_Queens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 */
public class Solution {

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        dfs(0,n,new ArrayList<>(),new int[n][n]);
        return res;
    }

    /**
     * 定义 确定当前行i的皇后所在的列，然后去下一行去确定下一个皇后的位置
     * @param i 此时应放置的行数 row
     * @param n 总行数
     * @param store 存储当时的地图
     * @param placed 保存哪些位置可以放置皇后
     */
    private void dfs(int i,int n,List<String> store,int[][] placed) {
        if (i == n) {
            res.add(new ArrayList<>(store));
            return;
        }

        // 寻找可以放置的列的位置
        for (int j = 0; j < n; j++) {
            if (placed[i][j] == 0) {
                // 可以放
                modifyPlaced(i,j,n,placed,1);
                store.add(generateMap(j,n));
                dfs(i+1,n,store,placed);
                store.remove(store.size()-1);
                modifyPlaced(i,j,n, placed,-1);
            }
        }
    }

    private String generateMap(int i,int n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j == i)
                sb.append('Q');
            else sb.append('.');
        }
        return sb.toString();
    }

    private void modifyPlaced(int row,int col,int n,int[][] placed,int val) {
        for (int i = row+1; i < n; i++) { // 同一列的赋值
            placed[i][col] += val;
        }
        for (int i = row+1,j = col+1; i < n && j < n; i++,j++) {// 右斜线赋值
                placed[i][j] += val;
        }
        for (int i = row+1,j = col-1; i < n && j > -1; i++,j--) { // 左斜线赋值
            placed[i][j] += val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;

        System.out.println(solution.solveNQueens(n));
    }
}
