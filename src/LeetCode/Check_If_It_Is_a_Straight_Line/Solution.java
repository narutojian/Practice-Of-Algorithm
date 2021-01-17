package LeetCode.Check_If_It_Is_a_Straight_Line;

/**
 * 1232. Check If It Is a Straight Line
 */
public class Solution {

    /**
     * 求出直线的一般方程式 对垂直x轴的直线进行特判
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        double k = 0,b;// 直线的一般方程式：y=k*x+b;
        boolean vertical = false; // true 表明直线垂直于x轴
        if (coordinates[1][0] - x == 0) {
            vertical = true;
            b = x; // 方程式为 x = b;
        }
        else {
            k = (coordinates[1][1]-y)*1.0/(coordinates[1][0]-x);
            b = y - k*x;
        }

        for (int i = 2; i < coordinates.length; i++) {
            x = coordinates[i][0];
            // x = b
            if (vertical) {
                if (x != b)
                    return false;
            }
            else {
                // y = k*x + b
                double curY = k*x+b;
                // 先判断 求出的y值是不是个整数 若是整数在进行类型强制转换
                if (curY%1 != 0 || (int) curY != coordinates[i][1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] coordinates = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6},
                {6,7}
        };

//        int[][] coordinates = {
//                {1,1},
//                {2,2},
//                {3,4},
//                {4,5},
//                {5,6},
//                {7,7}
//        };

//        int[][] coordinates = {
//                {0,0},
//                {0,1},
//                {0,-1}
//        };
        System.out.println(solution.checkStraightLine(coordinates));
    }
}
