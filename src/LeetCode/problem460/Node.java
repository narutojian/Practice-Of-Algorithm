package LeetCode.problem460;

public class Node {
    private int key;
    private int times;
    private Node next;

    public Node() {
    }

    public Node(int key, int times) {
        this.key = key;
        this.times = times;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
