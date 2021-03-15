package LeetCode.Find_Duplicate_Subtrees;

import LeetCode.DS.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 */
public class Solution {
    Map<String,Integer> memo = new HashMap<>();// 记录序列化后的字符串
    List<TreeNode> res = new ArrayList<>();// 重复的根节点

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializeTree(root);
        return res;
    }

    /**
     * 通过序列化每个子树来判断哪些子树是相同的
     * @param root
     * @return
     */
    private String serializeTree(TreeNode root) {
        if (root == null)
            return "#";

        StringBuilder cur = new StringBuilder();
        cur.append(root.val);
        cur.append(',');
        cur.append(serializeTree(root.left));
        cur.append(',');
        cur.append(serializeTree(root.right));
        String curString = cur.toString();

        if (memo.containsKey(curString)) {
            // 只出现一次 把重复的添加进结果
            // 出现多次 则不添加
            if (memo.get(curString) == 1) {
                res.add(root);
                memo.put(curString,2);
            }
        }
        else memo.put(curString,1);
        return curString;
    }
}
