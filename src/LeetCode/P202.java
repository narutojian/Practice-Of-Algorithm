package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class P202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return dfs(n,set);
    }

    private boolean dfs(int n,Set<Integer> set) {
        if (n == 1) return true;
        if (!set.add(n)) return false;

        int next = 0;
        while (n != 0) {
            next += (int) Math.pow(n%10,2);
            n /= 10;
        }
        return dfs(next,set);
    }

    public static void main(String[] args) {
        P202 h = new P202();

        int n = 2;
        System.out.println(h.isHappy(n));
    }
}
