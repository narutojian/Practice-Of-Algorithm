package LeetCode.problem365;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS求解最短路径问题
 */
public class P365_Solution2 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z == x || z == y) return true;
        if (x == y || x+y < z) return false;

        HashSet<State> hashSet = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        State state = new State(0,0);
        hashSet.add(state);
        queue.add(state);

        while (!queue.isEmpty()) {
            State temp = queue.poll();
            int curX = temp.getRemainX();
            int curY = temp.getRemainY();
            if (curX == z || curY == z || curX+curY == z) {
                return true;
            }

            State[] nextStates = new State[6];
            // x 向 y 倒满或倒空
            nextStates[0] = new State(curX - Math.min(curX,y - curY),curY+Math.min(curX,y-curY));
            // y 向 x 倒满或倒空
            nextStates[1] = new State(curX + Math.min(curY,x-curX),curY-Math.min(curY,x-curX));
            // x 加满
            nextStates[2] = new State(x,curY);
            // x 倒空
            nextStates[3] = new State(0,curY);
            // y 加满
            nextStates[4] = new State(curX,y);
            // y 倒空
            nextStates[5] = new State(curX,0);

            for (int i = 0; i < 6; i++) {
                if (!hashSet.contains(nextStates[i])) {
                    hashSet.add(nextStates[i]);
                    queue.add(nextStates[i]);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P365_Solution2 h = new P365_Solution2();
//        int x = 3;
//        int y = 5;
//        int z = 4;
        int x = 6;
        int y = 9;
        int z = 1;
        System.out.println(h.canMeasureWater(x,y,z));
    }
}
