package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P120 {
    /**
     * 从上至下开始递推
     * 求出所有的可能性 找出其中最小的一个值
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int ans = 0;
        dp[0] = triangle.get(0).get(0);
        int temp,prev = 0,cur;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp = triangle.get(i).get(j);
                cur = dp[j];
                if (j == 0) dp[j] = cur + temp;
                else if (j == triangle.get(i).size() -1) dp[j] = prev+temp;
                else dp[j] = Math.min(prev,cur) + temp;
                prev = cur;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[ans] > dp[i]) ans = i;
        }
        return dp[ans];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        P120 h = new P120();
        h.minimumTotal(triangle);
    }
}
