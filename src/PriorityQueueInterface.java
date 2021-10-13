/**
 * Interface for a PriorityQueue MaxHeap
 * data structure.
 *
 * @author Elijah Sorensen
 * @author cs321-instructors
 * @version CS321: Fall 2021
 */
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
