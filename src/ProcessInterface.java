/**
 * Interface for a <code>Process</code> object
 * requiring handling by a CPU. Each <code>Process</code>
 * has a(n) <code>priority</code>, <code>timeRemaining</code>,
 * <code>arrival</code> and <code>waitingTime</code>.
 *
 * @author Elijah Sorensen
 * @author cs321-instructors
 * @version CS321: Fall 2021
 */
public interface ProcessInterface {
	/**
	 * Returns an integer value representing
	 * the priority of this <code>Process</code>.
	 *
	 * @return the priority of this <code>Process</code>
	 */
	public int getPriority();

	/**
	 * Sets the priority value for this
	 * <code>Process</code>.
	 *
	 * @param priority the value to set the priority to
	 */
	public void setPriority(int priority);

	/**
	 * Returns an integer value representing
	 * the time remaining to complete this
	 * <code>Process</code>.
	 *
	 * @return the time remaining to complete this
	 * <code>Process</code>.
	 */
	public int getTimeRemaining();

	/**
	 * Decrements the <code>timeRemaining</code> for
	 * this <code>Process</code>.
	 */
	public void decrementTimeRemaining();

	/**
	 * Returns <code>true</code> if this <code>Process</code>
	 * is complete.
	 *
	 * @return <code>true</code> if the process is finished
	 */
	public boolean finished();

	/**
	 * Returns the integer value representing the time
	 * this <code>Process</code> started.
	 *
	 * @return the time the <code>Process</code> started
	 * processing.
	 */
	public int getArrivalTime();

	/**
	 * Returns the amount of time left to complete
	 * this <code>Process</code>.
	 *
	 * @return <code>arrivalTime</code> - <code>timeRemaining</code>
	 */
	public int getWaitingTime();

	/**
	 * Increments the <code>waitingTime</code> for this
	 * <code>Process</code>.
	 */
	public void incrementWaitingTime();

	/**
	 * Sets <code>waitingTime</code> for this <code>Process</code>
	 * back to its initial <code>startTime</code>.
	 */
	public void resetWaitingTime(); 
}
