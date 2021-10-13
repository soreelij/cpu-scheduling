import java.util.Arrays;

/**
 * Process-based implementation of the MaxHeap
 * data structure.
 *
 * @author Elijah Sorensen
 * @version CS321: Fall 2021
 */
public class MaxHeap implements MaxHeapInterface {

    private final int INITIAL_CAPACITY = 10;

    protected Process[] heap;
    protected int size;

    /**
     * Builds a new <code>MaxHeap</code> with an initial
     * capacity of 10.
     */
    public MaxHeap() {

        heap = new Process[INITIAL_CAPACITY];
        size = 0;

    }

    @Override
    public int parent(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position - 1) >> 1;

    }

    @Override
    public int leftChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 1;

    }

    @Override
    public int rightChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 2;

    }

    @Override
    public void swap(int firstPosition, int secondPosition) throws IndexOutOfBoundsException {

        if (firstPosition < 0 || firstPosition > size) {

            throw new IndexOutOfBoundsException();

        } else if (secondPosition < 0 || secondPosition > size) {

            throw new IndexOutOfBoundsException();

        }

        Process p = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = p;

    }

    @Override
    public void maxHeapify(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            return;

        }

        int largest;

        int left = leftChild(position);
        int right = rightChild(position);

        if (left < size && heap[left].compareTo(heap[position]) >= 1) {

            largest = left;

        } else largest = position;

        if (right < size && heap[right].compareTo(heap[largest]) >= 1) {

            largest = right;

        }

        if (largest != position) {

            swap(position, largest);
            maxHeapify(largest);

        }

    }

    @Override
    public void insert(Process p) throws HeapException {

        if (size >= heap.length) {

            expandCapacity();

        }

        size += 1;
        heap[size - 1] = new Process(0, 0, Integer.MIN_VALUE);

        increaseKey(size - 1, p);

    }

    @Override
    public void increaseKey(int position, Process p) throws HeapException {

        if (p.compareTo(heap[position]) < 0) {

            throw new HeapException("Key is less than current");

        }

        heap[position] = p;

        while (position > 0 && heap[parent(position)].compareTo(heap[position]) < 0) {

            swap(position, parent(position));
            position = parent(position);

        }

    }

    @Override
    public Process extractMax() throws HeapException {

        if (size == 0) {
            throw new HeapException("Heap underflow error");
        }

        Process p = heap[0];

        heap[0] = heap[size - 1];

        size--;

        maxHeapify(0);

        return p;

    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public int size() { return size; }

    /** Increases the internal capacity of the <code>heap</code> array **/
    private void expandCapacity() { heap = Arrays.copyOf(heap, heap.length * 2); }

}
