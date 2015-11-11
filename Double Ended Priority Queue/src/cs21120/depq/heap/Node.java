package cs21120.depq.heap;

/**
 * Created by Jose on 11/11/2015.
 *
 * @author Jose.
 */
public class Node {

    private Comparable data;
    private Node left;
    private Node right;

    public Node(Comparable data) {
        this.data = data;
    }

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
