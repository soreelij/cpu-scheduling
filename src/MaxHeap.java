import java.util.Arrays;

public class MaxHeap {

    protected Process[] heap;
    protected int size;

    public MaxHeap() {

        heap = new Process[10];
        size = 0;

    }

    public int parent(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position - 1) >> 1;

    }

    public int leftChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 1;

    }

    public int rightChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 2;

    }

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

    public void insert(Process p) throws HeapException {

        if (size >= heap.length) {

            expandCapacity();

        }

        size += 1;
        heap[size - 1] = new Process(0, 0, Integer.MIN_VALUE);

        increaseKey(size - 1, p);

    }

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

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    private void expandCapacity() { heap = Arrays.copyOf(heap, heap.length * 2); }

}
