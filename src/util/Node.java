package util;

/**
 * @author Lin
 * @date 2023/1/4
 */
public class Node {
    public Node next;
    public int value;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{value=" + value + '}';
    }
}
