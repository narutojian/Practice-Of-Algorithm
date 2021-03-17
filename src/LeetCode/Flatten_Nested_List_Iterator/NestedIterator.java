package LeetCode.Flatten_Nested_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> memo;// 存储所有的值
    int n = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        memo = new ArrayList<>();
        dfs(0,nestedList);
    }

    @Override
    public boolean hasNext() {
        return n == memo.size() ? false : true;
    }

    @Override
    public Integer next() {
        return memo.get(n++);
    }

    /**
     * 递归
     * @param start
     * @param nestedList
     */
    private void dfs(int start,List<NestedInteger> nestedList) {
        if (start == nestedList.size())
            return;
        // 是整数
        if (nestedList.get(start).isInteger()) {
            memo.add(nestedList.get(start).getInteger());
        }
        else {
            // 是列表 对该列表进行遍历
            dfs(0,nestedList.get(start).getList());
        }
        // 递归下一层
        dfs(start+1,nestedList);
    }
}
