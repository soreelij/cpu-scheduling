/**
 * Interface for a random or pseudo-random
 * <code>ProcessGenerator</code>.
 *
 * @author ELijah Sorensen
 * @author cs321-instructors
 * @version CS321: Fall 2021
 */
public interface ProcessGeneratorInterface {
	/**
	 * Generate a new random process within the specified range.
	 *
	 * @param currentTime   The current time in the simulation.
	 * @param maxProcessTime Range for the time required to complete the process [1..maxProcessTime]
	 * @param maxPriority Range for the priority level [1..maxLevel]
	 * @return
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority); 

	/**
	 * Check if a new <code>Process</code> will arrive (based on the probability of arrival at a given instance of time).
	 *
	 * @return arrival rate < probability
	 */
	public boolean query(); 

}
