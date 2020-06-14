package DataStructure.UnionFind;

/**
 * 以求亲戚关系的例子来阐述并查集的算法
 *
 * 亲戚关系问题
 * 显然，a与b是亲戚，b与c是亲戚，则a与c也是亲戚。
 * 输入：N，M。N为问题涉及人数，这些人的编号为1，2，3，...N。M为有M行亲戚关系，每一行有a，b，表示a与b为亲戚关系。
 * 之后有Q行，每行有c，d，表示询问c与d是否为亲戚关系。
 * 输出：对于Q行的每一行，c与d是亲戚输出Yes，否则为No。
 */
public class UnionFindSet {

    public void makeSet(TreeNode[] treeNodes,int n) {
        for (int i = 1; i <= n; i++) {
            treeNodes[i].data = i; //树的节点为人的编号
            treeNodes[i].rank = 0; //初始高度为1
            treeNodes[i].parent = i; //初始时父亲节点为自身
        }
    }

    public int findSet(TreeNode[] treeNodes,int x) {
        if (x != treeNodes[x].parent) {
            return findSet(treeNodes,treeNodes[x].parent);
        }
        return x;
    }

    public void union(TreeNode[] treeNodes,int x,int y) {
        x = findSet(treeNodes,x);
        y = findSet(treeNodes,y);
        if (treeNodes[x].rank > treeNodes[y].rank) {
            treeNodes[y].parent = x;
        }
        else {
            treeNodes[x].parent = y;
            if (treeNodes[x].rank == treeNodes[y].rank) {
                treeNodes[y].rank++;
            }
        }
    }

    public static void main(String[] args) {
        UnionFindSet h = new UnionFindSet();
        int n = 10,m = 7;

        TreeNode[] treeNodes = new TreeNode[n+1];
        for (int i = 1; i <= n; i++) {
            treeNodes[i] = new TreeNode();
        }

        h.makeSet(treeNodes,n);
        h.union(treeNodes,2,4);
        h.union(treeNodes,5,7);
        h.union(treeNodes,1,3);
        h.union(treeNodes,8,9);
        h.union(treeNodes,1,2);
        h.union(treeNodes,5,6);
        h.union(treeNodes,2,3);

        System.out.println(h.findSet(treeNodes,3) == h.findSet(treeNodes,4));
        System.out.println(h.findSet(treeNodes,7) == h.findSet(treeNodes,10));
        System.out.println(h.findSet(treeNodes,8) == h.findSet(treeNodes,9));
    }
}
