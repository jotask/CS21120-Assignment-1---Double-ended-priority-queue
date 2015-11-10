package cs21120.depq.bst;

/**
 * Created by Jota on 10/11/2015.
 *
 * @author Jota.
 */
public class BST {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void offer(Comparable data){
        Node node = new Node(data);
        if(root == null){
            root = node;
            ++size;
            return;
        }
        Node parent = getFreeNode();
        node.parent = parent;
        if(parent.left == null){
            parent.left = node;
        }else{
            parent.right = node;
        }
        ++size;
        heapifyUp(node);
    }

    private void heapifyUp(Node node) {
        Node parent = node.parent;
        if(calcNodes(root) != size){
            throw new RuntimeException("ERROR HEAP");
        }
        if(node.compareTo(parent)){
            swap(node, node.parent);
            if(node.parent != root)
                heapifyUp(node.parent);
        }
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public int getSize(){
        return size;
    }

    public Comparable peekMost(){
        return max(null);
    }

    public Comparable peekLeast(){
        return min();
    }

    private Comparable min(){
        return root.data;
    }

    private Comparable max(Node n){
        if(n == null){
            max(root);
        }else{
            if(n.right != null){
                max(n.right);
            }else{
                return n.data;
            }
        }
    }

    public Node getFreeNode() {
        Node traverse = root;
        int maxSquare = 2;
        while (maxSquare <= size + 1) {
            maxSquare *= 2;
        }
        maxSquare /= 4;

        while (maxSquare > 1) {
            if ((maxSquare & (size + 1)) == 0) {
                traverse = traverse.left;
            } else {
                traverse = traverse.right;
            }
            maxSquare /= 2;
        }

        return traverse;
    }
}
