import java.util.Arrays;

// TODO
public class MaxHeap<T extends Comparable> implements MaxHeapInterface<T> {

    private T[] heap;
    private int size;

    public MaxHeap() {
        heap = (T[]) new Comparable[1];
        size = 0;
    }

    @Override
    public int parent(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position >= size) {

            throw new IndexOutOfBoundsException();

        }

        return position >> 1;

    }

    @Override
    public int leftChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position >= size) {

            throw new IndexOutOfBoundsException();

        }

        return position << 1;

    }

    @Override
    public int rightChild(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position >= size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 1;

    }

    @Override
    public void swap(int firstPosition, int secondPosition) throws IndexOutOfBoundsException {

        if (firstPosition < 0 || firstPosition >= size) {

            throw new IndexOutOfBoundsException();

        } else if (secondPosition < 0 || secondPosition >= size) {

            throw new IndexOutOfBoundsException();

        }

        T element = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = element;

    }

    public void maxHeapify(int position) throws IndexOutOfBoundsException {

        if (position < 0 || position >= size) {

            throw new IndexOutOfBoundsException();

        }

        T largest;
        int largestIndex;

        T left = heap[leftChild(position)];
        T right = heap[rightChild(position)];

        // TODO: Decide the best way to return the top parent node?
        if ((left.compareTo(heap[heap.length - 1]) >= 1) && (left.compareTo(heap[position]) >= 1)) {

            largest = left;
            largestIndex = leftChild(position);

        } else {

            largest = heap[position];
            largestIndex = position;

        }

        if ((right.compareTo(heap[heap.length - 1]) >= 1) && right.compareTo(largest) >= 1) {

            largest = right;
            largestIndex = rightChild(position);

        }

        if (largest.compareTo(heap[position]) != 0) {

            swap(position, largestIndex);
            maxHeapify(largestIndex);

        }

    }

    @Override
    public void insert(T element) {

        // TODO

        if (size >= heap.length) {

            expandCapacity();

        }

        heap[size] = element;

        int current = size;

        while(heap[current].compareTo(heap[parent(current)]) >= 1) {

            swap(current, parent(current));
            current = parent(current);

        }

        size++;

    }

    @Override
    public T extractMax() {

        T output = heap[0];

        heap[0] = heap[size--];

        maxHeapify(0);

        return output;
    }

    @Override
    public boolean isEmpty() {

        if (size != 0) {

            return false;

        } else return true;

    }

    @Override
    public int size() {
        return size;
    }

    private void expandCapacity() { heap = Arrays.copyOf(heap, heap.length * 2); }
}
