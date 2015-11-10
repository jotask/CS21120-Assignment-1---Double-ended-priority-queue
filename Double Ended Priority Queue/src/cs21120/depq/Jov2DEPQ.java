package cs21120.depq;

import cs21120.depq.bst.BST;

public class Jov2DEPQ implements DEPQ {

	private BST heap;

	public Jov2DEPQ() {
		heap = new BST();
	}

	public static void main(String[] args) {
		new Jov2DEPQ();
	}

	@Override
	public Comparable inspectLeast() {
		return heap.peekLeast();
	}

	@Override
	public Comparable inspectMost() {
		return heap.peekMost();
	}

	@Override
	public void add(Comparable c) {
		heap.offer(c);
	}

	@Override
	public Comparable getLeast() {
		//return heap.getMin();
		return null;
	}

	@Override
	public Comparable getMost() {
		//return heap.getMax();
		return null;
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public int size() {
		return heap.getSize();
	}
}
