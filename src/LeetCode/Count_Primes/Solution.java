package LeetCode.Count_Primes;

/**
 * 204. Count Primes
 */
public class Solution {

    /**
     * 时间复杂度 O(n^(1.5)) 超时
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int cnt = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                cnt++;
        }
        return cnt;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
