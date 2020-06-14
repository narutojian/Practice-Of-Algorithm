package LeetCode.contest176;

public class P5341 {
    private int[] list = new int[40000];
    private int index = 0;
    
    public void add(int num) {
        list[index++] = num;
    }

    public int getProduct(int k) {
        int ans = 1;
        for (int i = index-1; i >= index - k; i--) {
            if (list[i] == 0) return 0;
            ans *= list[i];
        }
        return ans;
    }
}
