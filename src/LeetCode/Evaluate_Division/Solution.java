package LeetCode.Evaluate_Division;

import java.util.*;

/**
 * 399. Evaluate Division
 */
public class Solution {

    /**
     * 图 DFS
     * 难点在于根本没想到是个能转为图的问题，看了提示才知道的
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        // 使用哈希表存储所有的点，以及点所映射到的邻接矩阵上的索引号
        Map<String,Integer> map = new HashMap<>();
        int count = 0;// 计数
        int n = equations.size();
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                temp = equations.get(i).get(j);
                if (!map.containsKey(temp)) {
                    map.put(temp,count++);
                }
            }
        }
        // 构建邻接矩阵
        double[][] adjMatrix = new double[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) adjMatrix[i][j] = 1;
                else adjMatrix[i][j] = -1.0;// 初始化 -1.0表示节点i不能到达节点j
            }
        }
        Integer indexFirst,indexSecond;// 记录当前equation的两个字符串所对应的索引号
        for (int i = 0; i < n; i++) {
            indexFirst = map.get(equations.get(i).get(0));
            indexSecond = map.get(equations.get(i).get(1));
            adjMatrix[indexFirst][indexSecond] = values[i];
            adjMatrix[indexSecond][indexFirst] = 1/values[i];
        }
        // 设置访问矩阵
        boolean[] visit = new boolean[count];
        // 计算queries
        for (int i = 0; i < queries.size(); i++) {
            indexFirst = map.get(queries.get(i).get(0));
            indexSecond = map.get(queries.get(i).get(1));
            // 不存在的数
            if (indexFirst == null || indexSecond == null)
                ans[i] = -1.0;
            else {
                // 深度优先搜索
                for (int j = 0; j < count; j++) {
                    visit[j] = false;
                }
                visit[indexFirst] = true;
                ans[i] = dfs(indexFirst,indexSecond,1,adjMatrix,visit);
            }
        }
        return ans;
    }

    /**
     * DFS
     * @param start
     * @param end
     * @param res
     * @param matrix
     * @param visit
     * @return
     */
    double dfs(int start,int end,double res,double[][] matrix,boolean[] visit) {
        if (start == end) return res;
        double temp;
        for (int i = 0; i < matrix.length; i++) {
            if (visit[i]) continue;
            if (matrix[start][i] != -1.0) {
                visit[i] = true;
                temp = dfs(i,end,res*matrix[start][i],matrix,visit);
                if ( temp != -1.0)
                    return temp;
                visit[i] = false;// 回溯
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        List<List<String>> equations = new LinkedList<>();
//        equations.add(Arrays.asList("a","b"));
//        equations.add(Arrays.asList("b","c"));
//        double[] values = {2.0,3.0};
//        List<List<String>> queries = new LinkedList<>();
//        queries.add(Arrays.asList("a","c"));
//        queries.add(Arrays.asList("b","a"));
//        queries.add(Arrays.asList("a","e"));
//        queries.add(Arrays.asList("a","a"));
//        queries.add(Arrays.asList("x","x"));

        // test2
//        List<List<String>> equations = new LinkedList<>();
//        equations.add(Arrays.asList("a","b"));
//        equations.add(Arrays.asList("b","c"));
//        equations.add(Arrays.asList("bc","cd"));
//        double[] values = {1.5,2.5,5.0};
//        List<List<String>> queries = new LinkedList<>();
//        queries.add(Arrays.asList("a","c"));
//        queries.add(Arrays.asList("c","b"));
//        queries.add(Arrays.asList("bc","cd"));
//        queries.add(Arrays.asList("cd","bc"));

        // test2
        List<List<String>> equations = new LinkedList<>();
        equations.add(Arrays.asList("a","b"));
        double[] values = {0.5};
        List<List<String>> queries = new LinkedList<>();
        queries.add(Arrays.asList("a","b"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("x","y"));
        double[] ans = solution.calcEquation(equations,values,queries);

        System.out.println(Arrays.toString(ans));
    }
}
