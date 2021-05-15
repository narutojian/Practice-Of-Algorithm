package LeetCode.Path_With_Minimum_Effort;

/**
 * 图的边
 */
public class Edges {
    int from;// 起始点
    int to; // 终点
    int height;// 权重

    public Edges(int from,int to,int height) {
        this.from = from;
        this.to = to;
        this.height = height;
    }

    public Edges(int to,int height) {
        this.to = to;
        this.height = height;
    }
}
