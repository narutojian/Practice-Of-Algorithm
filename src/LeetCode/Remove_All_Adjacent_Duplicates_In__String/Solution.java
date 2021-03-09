package LeetCode.Remove_All_Adjacent_Duplicates_In__String;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class Solution {

    /**
     * 模拟 数组记录
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        int n = S.length();
        boolean[] removed =  new boolean[n];// 记录哪些元素移除了
        boolean flag;

        while (true) {
            flag = false;
            int pre = -1;
            int cur = 0;
            while (cur < n) {
                if (!removed[cur]) {
                    if (pre == -1) {
                        pre = cur;
                    }
                    else {
                        if (S.charAt(pre) == S.charAt(cur)) {
                            removed[pre] = true;
                            removed[cur] = true;
                            flag = true;
                            pre = -1;
                        }
                        else pre = cur;
                    }
                }
                cur++;
            }
            if (!flag) break;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                res.append(S.charAt(i));
            }
        }
        return res.toString();
    }
}
