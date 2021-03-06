/**
 * Interface for a MaxHeap of <code>Process</code>
 * objects
 *
 * @author Elijah Sorensen
 * @version CS 321: Fall 2021
 *
 */
public interface MaxHeapInterface {

    /**
     * Returns the index of the parent node
     * for the node contained at the specified
     * <code>position</code>.
     *
     * @param position the index value of a node contained in
     *                 this <code>MaxHeap</code>
     * @return index of the parent of the node
     * stored at the specified <code>position</code>
     * @throws IndexOutOfBoundsException if the <code>position</code>
     * is out of range (position < 0 || position > size)
     */
    public int parent(int position) throws IndexOutOfBoundsException;

    /**
     * Returns the index of the left child node
     * for the parent node contained at the specified
     * <code>position</code>.
     *
     * @param position the index value of a node contained in
     *                 this <code>MaxHeap</code>
     * @return index of the left child of the node
     * stored at the specified <code>position</code>.
     * @throws IndexOutOfBoundsException if the <code>position</code>
     * is out of range (position < 0 || position > size)
     */
    public int leftChild(int position) throws IndexOutOfBoundsException;

    /**
     * Returns the index of right child node for the
     * parent node contained at the specified
     * <code>position</code>.
     *
     * @param position the index of a node contained in this
     *                 this <code>MaxHeap</code>
     * @return index of the right child of the node
     * stored at the specified <code>position</code>
     * @throws IndexOutOfBoundsException if the <code>position</code>
     * is out of range (position < 0 || position > size)
     */
    public int rightChild(int position) throws IndexOutOfBoundsException;

    /**
     * Swaps the nodes stored at the specified
     * <code>firstPosition</code> and <code>secondPosition</code>
     * index values.
     *
     * @param firstPosition the index of the first node
     * @param secondPosition the index of the second node
     * @throws IndexOutOfBoundsException if the <code>firstPosition</code>
     * or the <code>secondPosition</code> are out of range
     * (position < 0 || position >= size)
     */
    public void swap(int firstPosition, int secondPosition) throws IndexOutOfBoundsException;

    /**
     * Maintains the max-heap property of the tree or sub-tree stored
     * at the specified <code>position</code> in this <code>MaxHeap</code>
     * by arranging its nodes from largest to smallest.
     *
     * @param position the position of the sub-tree to MaxHeapify
     * @throws IndexOutOfBoundsException if the <code>position</code>
     * is out of range (index < 0 || index >= size)
     */
    public void maxHeapify(int position) throws IndexOutOfBoundsException;

    /**
     * Stores the specified element in this <code>MaxHeap</code>.
     *
     * @param p the <code>Process</code> to insert into
     *        the <code>MaxHeap</code>
     * @throws HeapException from the call to increaseKey
     */
    public void insert(Process p) throws HeapException;

    /**
     * Updates and increases the key value of the <code>Process</code>
     * stored at the specified position
     *
     * @param position the index to place the updated key
     * @param p the key <code>Process</code> to add and increase
     *        at the <code>position</code>
     * @throws HeapException if the given key is smaller than the value
     *         stored at the <code>position</code>
     */
    public void increaseKey(int position, Process p) throws HeapException;

    /**
     * Returns the largest element stored within this <code>MaxHeap</code>.
     *
     * @return the greatest <code>Process</code> in this
     * <code>MaxHeap</code> (based on compareTo)
     * @throws HeapException if the heap is empty (underflow error)
     */
    public Process extractMax() throws HeapException;

    /**
     * Returns <code>true</code> if this <code>MaxHeap</code>
     * contains no Processes
     *
     * @return <code>true</code> if this <code>MaxHeap</code>
     * is empty
     */
    public boolean isEmpty();

    /**
     * Returns the size of the array containing this
     * <code>MaxHeap</code>
     *
     * @return the size of the <code>MaxHeap</code>
     */
    public int size();
}
