package LeetCode;

import java.util.ArrayList;

public class P42 {
    private int ans = 0;

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        getAns(0,height.length-1,-1,-1,height);
        return ans;
    }

    private void getAns(int start, int end, int left, int right, int[] height) {
        if (end <= start) return;
        ArrayList<Integer> integers = new ArrayList<>();
        int max = 0,horizon,first,last;
        for (int i = start; i <= end; i++) {
            if (max < height[i]) max = height[i];
        }
        for (int i = start; i <= end; i++) {
            if (max == height[i]) integers.add(i);
        }

        first = integers.get(0);
        if (left != -1) {
            horizon = Math.min(height[first],height[left]);
            for (int i = left+1; i < first; i++) {
                ans += horizon - height[i];
            }
        }
        else getAns(start,first-1,-1,first,height);

        last = integers.get(integers.size()-1);
        if (right != -1) {
            horizon = Math.min(height[last],height[right]);
            for (int i = last+1; i < right; i++) {
                ans += horizon - height[i];
            }
        }
        else getAns(last+1,end,last,-1,height);

        horizon = max;
        for (int i = 0; i < integers.size() - 1; i++) {
            left = integers.get(i);
            right = integers.get(i+1);
            for (int j = left+1; j < right; j++) {
                ans += horizon - height[j];
            }
        }
    }

    public static void main(String[] args) {
        P42 h = new P42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(h.trap(height));
    }
}
