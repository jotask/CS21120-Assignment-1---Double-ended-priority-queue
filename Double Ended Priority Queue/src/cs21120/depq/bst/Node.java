package cs21120.depq.bst;

/**
 * Created by Jota on 10/11/2015.
 *
 * @author Jota.
 */
public class Node{

    public Comparable data;
    public Node parent, left, right;

    public Node(Comparable data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
    }

}
