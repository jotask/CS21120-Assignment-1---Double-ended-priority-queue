package cs21120.depq;

import cs21120.depq.heap.Heap;

public class Jov2DEPQ{

	private DEPQ heap;

	public Jov2DEPQ() {
		heap = new Heap();
	}

	public Comparable inspectLeast() {
		return heap.inspectLeast();
	}

	public Comparable inspectMost() {
		return heap.inspectMost();
	}

	public void add(Comparable c) { heap.add(c); }

	public Comparable getLeast() { return heap.getLeast(); }

	public Comparable getMost() { return heap.getMost(); }

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public int size() {
		return heap.size();
	}

	public void printSize(){
		System.out.println("Size: " + size());
	}

	public static void main(String[] args) {
		Jov2DEPQ depq = new Jov2DEPQ();
		for(int i = 0; i < 10; i++){
			depq.add(i);
		}
		depq.printSize();
		System.out.println("------------------------------");
		Comparable peekLeast = depq.inspectLeast();
		System.out.println("Peek Least: " + peekLeast.toString() + " with size " + depq.size());
		Comparable peekMost = depq.inspectMost();
		System.out.println("Peek Most: " + peekMost.toString() + " with size " + depq.size());
		System.out.println("------------------------------");
		System.out.println("	Least: " + depq.inspectLeast() + " Most: " + depq.inspectMost());
		Comparable getLeast = depq.getLeast();
		System.out.println("Get Least: " + getLeast.toString() + " with size " + depq.size());
		System.out.println("	Least: " + depq.inspectLeast() + " Most: " + depq.inspectMost());
		Comparable getMost = depq.getMost();
		System.out.println("Get Least: " + getMost.toString() + " with size " + depq.size());
		System.out.println("	Least: " + depq.inspectLeast() + " Most: " + depq.inspectMost());
		System.out.println("------------------------------");
		depq.printSize();

	}

}
