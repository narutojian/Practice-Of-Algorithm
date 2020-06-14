package LeetCode.Leetcode2020春季个人赛;

public class P2 {
    int ans = 0;
    public int numWays(int n, int[][] relation, int k) {
        dfs(0,n,relation,k,0);
        return ans;
    }

    private void dfs(int cur,int n,int[][] relation,int k,int round) {
        if (round > k || (round == k && cur != n-1)) return; 
        if (cur == n-1 && k == round) {
            ans ++;
            return;
        }

        int next;
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] != cur) continue;
            next = relation[i][1];
            round++;
            dfs(next,n,relation,k,round);
            round--;
        }
    }

    public static void main(String[] args) {
        P2 h = new P2();
//        int n = 5;
//        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
//        int k = 3;
        int n = 3;
        int[][] relation = {{0,2},{2,1}};
        int k = 2;
        System.out.println(h.numWays(n,relation,k));
    }
}
