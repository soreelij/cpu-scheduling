public interface PriorityQueueInterface {
    /**
     * Adds the specified <code>Process</code> to
     * this <code>PriorityQueue</code>.
     *
     * @param p the <code>Process</code> to add
     *          to the queue
     */
    public void enqueue(Process p);

    /**
     * Removes the highest priority <code>Process</code>
     * from this <code>PriorityQueue</code>.
     *
     * @return the highest priority <code>Process</code>
     * in the queue
     */
    public Process dequeue();

    /**
     * Returns <code>true</code> if
     * this <code>PriorityQueue</code> does not contain
     * any <code>Processes</code>.
     *
     * @return <code>true</code> if the queue is empty
     */
    public boolean isEmpty();

    /**
     * Increases the key value of the element stored at the specified
     * <code>position</code> in this <code>MaxHeap</code>.
     *
     * @param position the position of the element
     * @param key the key value to increase the element to
     */
    public void increaseKey(int position, int key) throws HeapException;

    /**
     * Updates the <code>priority</code> of the provided
     * <code>Process</code> within the queue
     *
     * @param next the <code>Process</code> to
     * @param timeToIncrementPriority the amount of time to increment
     *                                the <code>priority</code> of
     *                                <code>next</code>
     * @param maxPriority the maximum possible <code>priority</code>
     */
    public void update(Process next, int timeToIncrementPriority, int maxPriority); 
	
}
