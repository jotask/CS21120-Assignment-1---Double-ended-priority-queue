package cs21120.depq;

public class Jov2DEPQ implements DEPQ{

    private Node root;
    private int size;

    public Jov2DEPQ() {
        this.root = null;
        this.size = 0;
    }

    private Node search(Comparable element) {
        Node node = root;
        while (node != null && node.value != null && node.value != element) {
            if (element.compareTo(node.value) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private void delete(Comparable element) {
        Node deleteNode = search(element);
        if (deleteNode == null) {
            throw new RuntimeException("Something is wrong");
        }
        if (deleteNode.left == null) {
            transplant(deleteNode, deleteNode.right);
        } else if (deleteNode.right == null) {
            transplant(deleteNode, deleteNode.left);
        } else {
            Node successorNode = deleteNode.right;
            while (successorNode.left != null) {
                successorNode = successorNode.left;
            }
            if (successorNode.parent != deleteNode) {
                transplant(successorNode, successorNode.right);
                successorNode.right = deleteNode.right;
                successorNode.right.parent = successorNode;
            }
            transplant(deleteNode, successorNode);
            successorNode.left = deleteNode.left;
            successorNode.left.parent = successorNode;
        }
        size--;
    }

    private void transplant(Node nodeToReplace, Node newNode) {
        if (nodeToReplace.parent == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = nodeToReplace.parent;
        }
    }

    @Override
    public Comparable inspectLeast() {
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    @Override
    public Comparable inspectMost() {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    @Override
    public void add(Comparable value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return;
        }
        Node insertParentNode = null;
        Node searchTempNode = root;
        while (searchTempNode != null && searchTempNode.value != null) {
            insertParentNode = searchTempNode;
            if (value.compareTo(searchTempNode.value) < 0) {
                searchTempNode = searchTempNode.left;
            } else {
                searchTempNode = searchTempNode.right;
            }
        }
        Node newNode = new Node(value, insertParentNode);
        if (insertParentNode.value.compareTo(newNode.value) > 0) {
            insertParentNode.left = newNode;
        } else {
            insertParentNode.right = newNode;
        }
        size++;
    }

    @Override
    public Comparable getLeast() {
        Comparable least = inspectLeast();
        delete(least);
        return least;

    }

    @Override
    public Comparable getMost() {
        Comparable most = inspectMost();
        delete(most);
        return most;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return size;
    }

    public static class Node {

        public Comparable value;
        public Node parent;
        public Node left;
        public Node right;

        public Node(Comparable value) {
            this(value, null, null, null);
        }

        public Node(Comparable value, Node parent) {
            this(value, parent, null, null);
        }

        private Node(Comparable value, Node parent, Node left, Node right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }
}