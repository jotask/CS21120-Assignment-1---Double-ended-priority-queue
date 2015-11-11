package cs21120.depq;


/**
 * A simple Double Ended Priority Queue Interface
 * @author bpt
 */
public interface DEPQ {

    /**
     * Returns the smallest element in the DEPQ but does not remove it from the DEPQ
     * @return returns the smallest element in the DEPQ
     */
    Comparable inspectLeast();

    /**
     * Returns the largest element in the DEPQ but does not remove it from the DEPQ
     * @return returns the largest element in the DEPQ
     */
    Comparable inspectMost();

    /**
     * Adds an element to the DEPQ
     * @param c the element to insert into the DEPQ
     */
    void add(Comparable c);

    /**
     * Removes the smallest element from the DEPQ and returns it
     * @return returns the smallest element in the DEPQ
     */
    Comparable getLeast();


    /**
     * Removes the largest element from the DEPQ and returns it
     * @return returns the largest element in the DEPQ
     */
    Comparable getMost();

    /**
     * Checks if the DEPQ is empty
     * @return returns true if the queue is empty
     */
    boolean isEmpty();

    /**
     * Returns the size of the DEPQ
     * @return returns the number of elements currently in the DEPQ
     */
    int size();
}