package cs21120.depq.heap;

import cs21120.depq.DEPQ;

/**
 * Created by Jose on 11/11/2015.
 *
 * @author Jose.
 */
public class Heap implements DEPQ {

    private Node root;
    private Comparable least;
    private Comparable most;
    private int size;

    public Heap() {
        root = null;
        least = null;
        most = null;
        size = 0;
    }

    @Override
    public Comparable inspectLeast() {
        return least;
    }

    @Override
    public Comparable inspectMost() {
        return most;
    }

    @Override
    public void add(Comparable c) {
//        System.out.println("Anadir: " + c.toString());
        insert(root, c);
        inspect();
        size++;
    }

    private void insert(Node node, Comparable c){
        Node temp  = node;
        if(root == null){
            root = new Node(c);
            return;
        }
        int comp = c.compareTo(temp.getData());
        if(comp < 0){
            if(temp.getLeft() == null){
                temp.setLeft(new Node(c));
            }else{
                insert(temp.getLeft(), c);
            }
        }else if(comp > 0){
            if(temp.getRight() == null){
                temp.setRight(new Node(c));
            }else{
                insert(temp.getRight(), c);
            }
        }else{
            // Same data
            return;
        }
    }

    private void remove(Comparable c){
        remove(root, c);
        size--;
    }

    private void inspect(){
        // Inspect Least
        if(root != null) {
            Node t1 = root;
            while (t1.getLeft() != null) {
                t1 = t1.getLeft();
            }
            least = t1.getData();

            // Inspect Most
            Node t2 = root;
            while (t2.getRight() != null) {
                t2 = t2.getRight();
            }
            most = t2.getData();
        }else{
            System.err.println("root is null");
        }
    }

    private void remove(Node node, Comparable c){
        Node temp = node;
        Node prev = null;
        while(temp != null){
            int comp = c.compareTo(temp.getData());
            if(comp == 0){
                break;
            }else if(comp < 0){
                prev = temp;
                temp = temp.getLeft();
            }else{
                prev = temp;
                temp = temp.getRight();
            }
        }
        if(temp == null){
            return;
        }else{
            if(temp.getLeft() == null){
                if(temp == root){
                    root = temp.getRight();
                }else if(temp == prev.getLeft()){
                    prev.setLeft(temp.getRight());
                }else{
                    prev.setRight(temp.getRight());
                }
            }else if(temp.getRight() == null){
                if(temp == root){
                    root = temp.getLeft();
                }else if(temp == prev.getLeft()){
                    prev.setLeft(temp.getLeft());
                }else{
                    prev.setRight(temp.getLeft());
                }
            }else{
                Node l = temp.getLeft();
                Node r = temp.getRight();
                while(l.getRight() != null){
                    r = l;
                    l = l.getRight();
                }
                temp.setData(l.getData());
                if(r == temp){
                    r.setLeft(l.getLeft());
                }else{
                    r.setRight(l.getLeft());
                }
            }
        }
    }

    @Override
    public Comparable getLeast() {
        remove(least);
        inspect();
        return least;
    }

    @Override
    public Comparable getMost() {
        remove(most);
        inspect();
        return most;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
