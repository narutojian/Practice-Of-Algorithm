package LeetCode.Check_If_It_Is_a_Straight_Line;

public class Solution2 {

    /**
     * 共线向量 线性相关
     * 两个二维向量 组成的行列式的值为0
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        // 向量(x,y)
        int x = coordinates[1][0] - x0;
        int y = coordinates[1][1] - y0;

        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0] - x0;
            int yi = coordinates[i][1] - y0;

            if (x*yi - xi*y != 0) return false;
        }
        return true;
    }
}
