package LeetCode.Open_the_Lock;

import java.util.*;

/**
 * 752. Open the Lock
 */
public class Solution {

    /**
     * bfs
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String i : deadends) {
            set.add(i);
        }
        String start = "0000";
        if (set.contains(start))
            return -1;
        Set<String> exist = new HashSet<>();// 去除前面已经出现过的字符串密码
        Deque<String> deque = new LinkedList<>();
        deque.add(start);
        exist.add(start);
        int res = 0;

        while (!deque.isEmpty()) {
            int num = deque.size();
            while (num > 0) {
                String cur = deque.remove();
                if (cur.equals(target))
                    return res;
                List<String> choice = getPwd(cur);
                for (String temp : choice) {
                    if (!set.contains(temp) && !exist.contains(temp)) {
                        deque.add(temp);
                        exist.add(temp);
                    }
                }
                num--;
            }
            res++;
        }
        return -1;
    }

    private List<String> getPwd(String s) {
        List<String> choice = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            int x = sb.charAt(i) - '0';
            StringBuilder temp = new StringBuilder(sb);
            choice.add(temp.replace(i,i+1,""+(x+1)%10).toString());
            choice.add(temp.replace(i,i+1,""+(x-1+10)%10).toString());
        }
        return choice;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(solution.openLock(deadends,target));
    }
}
