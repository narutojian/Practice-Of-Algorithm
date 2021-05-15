package LeetCode.Path_With_Minimum_Effort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
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
            PriorityQueue<Edges> queue = new PriorityQueue<>(new Comparator<Edges>() {
                @Override
                public int compare(Edges o1, Edges o2) {
                    return o1.height - o2.height;
                }
            });
            boolean[][] visited = new boolean[rows][cols];
            queue.add(new Edges(-1,0,0));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Edges curEdge = queue.remove();
                int curRow = curEdge.to/cols;
                int curCol = curEdge.to%cols;
                if (curRow == rows-1 && curCol == cols-1) {
                    flag = true;
                    break;
                }
                int nextRow,nextCol;
                for (int i = 0; i < 4; i++) {
                    nextRow = curRow+dir[i][0];
                    nextCol = curCol+dir[i][1];
                    if (nextRow < rows && nextCol < cols && nextRow > -1 && nextCol > -1 && !visited[nextRow][nextCol] && Math.abs(heights[nextRow][nextCol]-heights[curRow][curCol]) <= mid) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new Edges(curEdge.to,nextRow*cols+nextCol,Math.abs(heights[nextRow][nextCol]-heights[curRow][curCol])));
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
        Solution2 solution2 = new Solution2();

        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

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

//        int[][] heights = {
//                {1,1000000}
//        };

        System.out.println(solution2.minimumEffortPath(heights));
    }
}
