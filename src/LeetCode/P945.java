package LeetCode;

public class P945 {
    /**
     * 暴力枚举
     * @param A 给定的序列
     * @return 返回最小增量
     */
    public int minIncrementForUnique(int[] A) {
        boolean[] visit = new boolean[80000];
        int cur,ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (!visit[A[i]]) {
                visit[A[i]] = true;
            }
            else {
                cur = A[i];
                while (visit[A[i]]) {
                    A[i]++;
                }
                visit[A[i]] = true;
                ans += A[i] - cur;
            }
        }

        return ans;
    }

    /**
     * 优化 暴力枚举
     *
     * @param A 给定的序列
     * @return 最小增量
     */
    public int minIncrementForUnique_Solution2(int[] A) {
        int[] visit = new int[80000];
        int ans = 0,min = Integer.MAX_VALUE;

        for (int num :
                A) {
            visit[num]++;
            min = Math.min(min, num);
        }

        int duplicate = 0,length = A.length,i = min;
        for (; i < 80000 && length > 0; i++) {
            length -= visit[i];
            if (visit[i] == 1) continue;
            else if (visit[i] > 1) {
                duplicate += visit[i]-1;
                ans -= (visit[i]-1)*i;
            }
            else {
                if (duplicate != 0) {
                    ans += i;
                    duplicate--;
                }
            }
        }
        while (duplicate > 0) {
            ans += (i++);
            duplicate--;
        }

        return ans;
    }


    public int minIncrementForUnique_Solution3(int[] A) {
        int[] visit = new int[A.length+40000];
        int ans = 0,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;

        for (int num :
                A) {
            visit[num]++;
            min = Math.min(min, num);
            max = Math.max(max,num);
        }

        int duplicate = 0;
        for (int i = min; i <= max; i++) {
            if (visit[i] > 1) {
                duplicate += visit[i]-1;
                ans -= (visit[i]-1)*i;
            }
            else if (duplicate > 0 && visit[i] == 0) {
                ans += i;
                duplicate--;
            }
        }
        while (duplicate > 0) {
            ans += (++max);
            duplicate--;
        }

        return ans;
    }

    public static void main(String[] args) {
        P945 h = new P945();
//        int[] A = {0,1,4,2,2,4,7,1};
        int[] A = {3,2,1,2,1,7};
//        System.out.println(h.minIncrementForUnique(A));
        System.out.println(h.minIncrementForUnique_Solution2(A));
    }
}
