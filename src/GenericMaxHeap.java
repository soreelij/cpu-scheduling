import java.util.Arrays;
import java.util.NoSuchElementException;

public class GenericMaxHeap<T extends Comparable<T>> implements GenericMaxHeapInterface<T> {

    protected T[] heap;
    protected int size;

    public GenericMaxHeap() {

        heap = (T[]) new Process[10];
        size = 0;

    }

    @Override
    public int parent(int position) throws IndexOutOfBoundsException {

        if (position < 1 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return position >> 1;

    }

    @Override
    public int leftChild(int position) throws IndexOutOfBoundsException {

        if (position < 1 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return position << 1;

    }

    @Override
    public int rightChild(int position) throws IndexOutOfBoundsException {

        if (position < 1 || position > size) {

            throw new IndexOutOfBoundsException();

        }

        return (position << 1) + 1;

    }

    @Override
    public void swap(int firstPosition, int secondPosition) throws IndexOutOfBoundsException {

        if (firstPosition < 1 || firstPosition > size) {

            throw new IndexOutOfBoundsException();

        } else if (secondPosition < 1 || secondPosition > size) {

            throw new IndexOutOfBoundsException();

        }

        T element = heap[firstPosition];
        heap[firstPosition] = heap[secondPosition];
        heap[secondPosition] = element;

    }

    public void maxHeapify(int position) throws IndexOutOfBoundsException {

        if (position < 1 || position > size) {

            return;

        }

        int largest;

        int left = leftChild(position);
        int right = rightChild(position);

        if (left <= size && heap[left].compareTo(heap[position]) >= 1) {

            largest = left;

        } else largest = position;

        if (right <= size && heap[right].compareTo(heap[largest]) >= 1) {

            largest = right;

        }

        if (largest != position) {

            swap(position, largest);
            maxHeapify(largest);

        }

    }

    @Override
    public void insert(T element) {

        if (size == 0) {

            heap[1] = element;
            size++;

        } else {

            int current = size + 1;

            if (current >= heap.length) {

                expandCapacity();

            }

            heap[current] = element;

            size++;

            while (parent(current) != 0 && heap[current].compareTo(heap[parent(current)]) >= 1) {

                swap(current, parent(current));
                current = parent(current);

            }

        }

    }

    @Override
    public T extractMax() {

        //TODO: Fix this

        T output = heap[1];

        if (output == null) {

            throw new NoSuchElementException();

        }

        heap[1] = heap[size];

        size--;

        maxHeapify(1);

        return output;

    }

    @Override
    public boolean isEmpty() {

        if (size != 0) {

            return false;

        } else return true;

    }

    @Override
    public int size() { return size; }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 1; i <= size; i++) {

            builder.append(heap[i]);
            builder.append(",");

        }

        if(!isEmpty()) {

            builder.delete(builder.length() - 1, builder.length());

        }

        builder.append("]");

        return builder.toString();
    }

    private void expandCapacity() { heap = Arrays.copyOf(heap, heap.length * 2); }
}
