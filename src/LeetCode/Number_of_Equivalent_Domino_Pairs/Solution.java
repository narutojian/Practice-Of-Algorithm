package LeetCode.Number_of_Equivalent_Domino_Pairs;

/**
 * 1128. Number of Equivalent Domino Pairs
 */
public class Solution {

    /**
     * 哈希 计数
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        int res = 0;
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] == dominoes[i][1]) {
                res += map[dominoes[i][0]][dominoes[i][1]];
            }
            else res += map[dominoes[i][0]][dominoes[i][1]]+map[dominoes[i][1]][dominoes[i][0]];
            map[dominoes[i][0]][dominoes[i][1]]++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] dominoes = {
//                {1,2},
//                {2,1},
//                {3,4},
//                {5,6}
//        };

//        int[][] dominoes = {
//                {1,2},
//                {2,1},
//                {3,4},
//                {5,4},
//                {1,2},
//                {4,3}
//        };

        int[][] dominoes = {
                {1,1},
                {2,2},
                {1,1},
                {1,2},
                {1,2},
                {1,1}
        };

        System.out.println(solution.numEquivDominoPairs(dominoes));
    }
}
