package LeetCode.Clumsy_Factorial;

/**
 * 1006. Clumsy Factorial
 */
public class Solution {

    /**
     * 递归 模拟
     * @param N
     * @return
     */
    public int clumsy(int N) {
        return (int) clumsy(N,new char[]{' ','*','/','+','-'});
    }

    /**
     * 定义 在指定的operations的操作序列下， 返回值
     * @param n
     * @param operations
     * @return
     */
    private long clumsy(int n,char[] operations) {
        if (n == 1)
            return 1;
        long res = n;
        for (int i = n-1; i > 0; i--) {
            int num = n-i;
            if (num == 4) {
                if (operations[num] == '+')
                    return res + clumsy(i,operations);
                else {
                    swap(operations,num-1,num);
                    return res - clumsy(i,operations);
                }
            }
            switch (operations[num]) {
                case '*' : res *= i;break;
                case '/' : res /= i;break;
                case '+' : res += i;break;
                case '-' : res -= i; break;
            }
        }
        return res;
    }

    private void swap(char[] operations,int i,int j) {
        char temp = operations[i];
        operations[i] = operations[j];
        operations[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int N = 15;

        System.out.println(solution.clumsy(N));
    }
}
