package LeetCode.Maximal_Square;

/**
 * 221. Maximal Square
 */
public class Solution {

    /**
     * 暴力+优化
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int maxLen = Math.min(m,n);
        int curLen;// 当前正方形的长度
        boolean flag;// 边长加1的正方形可否找到
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                int curMaxLen = Math.min(m-i,n-j);
                if (res >= curMaxLen) continue;
                curLen = 1;
                flag = true;

                while (flag && curLen <= curMaxLen) {
                    res = Math.max(res,curLen);
                    A:for (int k = i; k < i+curLen+1 && k < m; k++) {
                        for (int l = j; l < j+curLen+1 && l < n; l++) {
                            if (k == i+curLen || l == j+curLen) {
                                if (matrix[k][l] == '0') {
                                    flag = false;
                                    break A;
                                }
                            }
                        }
                    }
                    curLen++;
                }
                if (res == maxLen) return res*res;
            }
        }
        return res*res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//        };

        // test2
//        char[][] matrix = {
//                {'0','1'},
//                {'1','0'}
//        };

        // test3
        char[][] matrix = {
                {'1','1'},
                {'1','1'}
        };
        System.out.println(solution.maximalSquare(matrix));
    }
}
