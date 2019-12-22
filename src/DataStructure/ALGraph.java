package DataStructure;

import java.util.Scanner;

/**
 * 邻接表数据结构
 */
public class ALGraph {
    int vLen; // 顶点个数
    int eLen; // 边个数
    VertexNode[] head;// 点链表
    /*
    点节点
     */
    private class VertexNode {
        int vertex;// 点
        EdgeNode firstEage;// 点对应的边链表的头指针
    }

    /*
    边节点
     */
    private class EdgeNode {
        int to; // 下一个点，它对应的另一个点在上一条边上或者是顶点
        int weight;// 权重
        EdgeNode next; // 下一条边节点
    }

    // 初始化
    public void init() {
        head = new VertexNode[vLen];
        for (int i = 0; i < head.length; i++) {
            head[i] = new VertexNode();
            head[i].vertex = i+1; // 默认点的值从1开始
        }
    }

    /**
     * 构建图
     * 这是构建图的每一个重复的步骤
     * @param start 边的起点
     * @param end 边的终点
     * @param weight 边之间的距离
     */
    public void buildGraph(int start,int end, int weight) {
        EdgeNode node = new EdgeNode();
        node.to = end;
        node.weight = weight;

        EdgeNode firstEdge = head[start-1].firstEage;
        if (firstEdge == null)
            head[start-1].firstEage = node;
        else {
            while (firstEdge.next != null)
                firstEdge = firstEdge.next;
            firstEdge.next = node;
        }
    }

    // 打印邻接表
    public void printGraph() {
        String s = "";
        for (int i = 0; i < head.length; i++) {
            s += head[i].vertex;
            while (head[i].firstEage != null) {
                s += "->"+head[i].firstEage.to;
                head[i].firstEage = head[i].firstEage.next;
            }
            s += "->null";
            System.out.println(s);
            s = "";
        }
    }

    public static void main(String[] args) {
        ALGraph graph = new ALGraph();

        Scanner cin = new Scanner(System.in);
        int n,m,first,second,dis;
        while ((n = cin.nextInt()) != 0 && (m = cin.nextInt()) != 0) {
            graph.vLen = n;
            graph.eLen = m;
            graph.init();
            for (int i = 0; i < m; i++) {
                first = cin.nextInt();
                second = cin.nextInt();
                dis = cin.nextInt();
                graph.buildGraph(first,second,dis);
            }
            graph.printGraph();
        }
    }
}
