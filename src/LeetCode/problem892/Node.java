package LeetCode.problem892;

public class Node implements Comparable<Node>{
    private int v;
    private int x;// 横坐标
    private int y;// 纵坐标

    public Node(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Node o) {
        return v - o.v;
    }
}
