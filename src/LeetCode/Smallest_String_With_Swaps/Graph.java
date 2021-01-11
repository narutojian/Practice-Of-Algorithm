package LeetCode.Smallest_String_With_Swaps;

public class Graph {
    int n;// 顶点个数
    Vertex[] vertices;// 顶点集

    public Graph(int n) {
        this.n = n;
        this.vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            this.vertices[i] = new Vertex();
        }
    }
}
class Edges {
    int to; // 邻接点
    Edges next;// 下一条边
    public Edges(int to,Edges next) {
        this.to = to;
        this.next = next;
    }
}
class Vertex {
    int round = 0; // 在第几个连通子图上 0 表示该点还没有被访问
    Edges first; // 邻接的第一条边
}