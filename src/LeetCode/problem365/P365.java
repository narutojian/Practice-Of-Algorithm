package LeetCode.problem365;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * dfs求解
 * 栈溢出
 */
public class P365 {
    private HashSet<List<Integer>> hashSet;

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z == x || z == y) return true;
        if (x == y) return false;

        hashSet = new HashSet<>();
        return dfs(0, 0, x, y, z);
    }

    private boolean dfs(int remainX, int remainY, int x, int y, int z) {
        List<Integer> arr = new ArrayList<>(2);
        arr.add(remainX);
        arr.add(remainY);
        if (hashSet.contains(arr))
            return false;
        if (remainX == z || remainY == z || remainX+remainY == z)
            return true;
        hashSet.add(arr);

        // x水壶向y水壶倒满或倒空
        if (dfs(remainX-Math.min(remainX,y-remainY),remainY+Math.min(remainX,y-remainY),x,y,z))
            return true;
        // y水壶向x水壶倒满或倒空
        if (dfs(remainX+Math.min(remainY,x-remainX),remainY-Math.min(remainX,x-remainX),x,y,z))
            return true;
        // x水壶加满
        if (dfs(x,remainY,x,y,z))
            return true;
        // x水壶倒空
        if (dfs(0,remainY,x,y,z))
            return true;
        // y水壶加满
        if (dfs(remainX,y,x,y,z))
            return true;
        // y水壶倒空
        return dfs(remainX, 0, x, y, z);
    }

    public static void main(String[] args) {
        P365 h = new P365();
//        int x = 3;
//        int y = 5;
//        int z = 4;
        int x = 6;
        int y = 9;
        int z = 1;
        System.out.println(h.canMeasureWater(x,y,z));
    }
}
