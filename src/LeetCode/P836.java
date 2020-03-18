package LeetCode;

public class P836 {

    /**
     * 逆向求解
     * 要求矩形是否重叠，如果考虑重叠的情况的话，那么会比较麻烦
     * 考虑不重叠的情况比较容易
     * @param rec1 矩形1
     * @param rec2 矩形2
     * @return 是否重叠
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec1[2] > rec2[0] && rec1[3] > rec2[1];
//        原先的做法
//        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1])
//            return false;
//        return true;
    }
}
