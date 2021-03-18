package LeetCode.Edit_Distance;

public class Solution2 {

    /**
     * 暴力递归
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return getMinDis(word1,word2,word1.length()-1,word2.length()-1);
    }

    /**
     * 定义 返回word1与word2相等需要的最小的操作次数
     * @param word1 1
     * @param word2 2
     * @param index1 字符串1的指针 从末尾开始
     * @param index2 字符串2的指针 从末尾开始
     * @return
     */
    private int getMinDis(String word1,String word2,int index1,int index2) {
        if (index1 == -1)
            return index2+1;
        if (index2 == -1)
            return index1+1;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return getMinDis(word1,word2,index1-1,index2-1);
        }
        else {
            int fir = getMinDis(word1,word2,index1,index2-1)+1;// 插入操作
            int sec = getMinDis(word1,word2,index1-1,index2)+1;// 删除操作
            int thi = getMinDis(word1,word2,index1-1,index2-1)+1;// 替换操作
            return Math.min(fir,Math.min(sec,thi));
        }
    }
}
