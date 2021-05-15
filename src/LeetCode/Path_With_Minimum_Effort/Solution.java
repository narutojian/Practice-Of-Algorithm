package LeetCode.Path_With_Minimum_Effort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1631. Path With Minimum Effort
 */
public class Solution {
    // 上右下左
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    /**
     * 二分搜索+BFS
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length; // 行
        int cols = heights[0].length; // 列
        int low = 0;
        int high = 999999;
        int mid;
        int ans = 0;
        while (low <= high) {
            mid = (low+high)/2;

            boolean flag = false;// 判断是否在hieght <= mid 能从(0,0)走到(row-1,col-1)
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];
            queue.add(new int[]{0,0});
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                if (cur[0] == rows-1 && cur[1] == cols-1) {
                    flag = true;
                    break;
                }
                int nextRow,nextCol;
                for (int i = 0; i < 4; i++) {
                    nextRow = cur[0]+dir[i][0];
                    nextCol = cur[1]+dir[i][1];
                    if (nextRow < rows && nextCol < cols && nextRow > -1 && nextCol > -1 && !visited[nextRow][nextCol] && Math.abs(heights[nextRow][nextCol]-heights[cur[0]][cur[1]]) <= mid) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow,nextCol});
                    }
                }
            }

            if (flag) {
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

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
        System.out.println(solution.minimumEffortPath(heights));
    }
}
