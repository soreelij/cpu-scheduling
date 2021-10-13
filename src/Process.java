/**
 * A <code>Process</code> object for simulation of CPU scheduling and
 * process-handling algorithms, with comparability to other <code>Process</code>
 * objects (based on priority and arrivalTime)
 *
 * @author Elijah Sorensen
 * @version CS321: Fall 2021
 */
public class Process implements Comparable<Process>, ProcessInterface {

    private int priority;
    private int timeRemaining;
    private int arrivalTime;
    private int waitingTime;

    /**
     * Builds a new <code>Process</code> object.
     *
     * @param arrivalTime the current time (when the <code>Process</code>
     *                    was instantiated)
     * @param timeRemaining the number of time units required to finish this
     *                      <code>Process</code>
     * @param priority the priority level for this <code>Process</code>
     */
    public Process(int arrivalTime, int timeRemaining, int priority) {

        this.arrivalTime = arrivalTime;
        this.timeRemaining = timeRemaining;
        this.priority = priority;
        this.waitingTime = 0;

    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    @Override
    public void decrementTimeRemaining() {
        timeRemaining--;
    }

    @Override
    public boolean finished() {
        return timeRemaining <= 0;
    }

    @Override
    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int getWaitingTime() {
        return waitingTime;
    }

    @Override
    public void incrementWaitingTime() {
        waitingTime++;
    }

    @Override
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    @Override
    public int compareTo(Process p) {

        if (this.priority > p.getPriority()) {

            return 1;

        } else if (this.priority < p.getPriority()) {

            return -1;

        } else if (this.arrivalTime > p.getArrivalTime()) {

            return -1;

        } else if (this.arrivalTime < p.getArrivalTime()) {

            return 1;

        } else return 0;

    }
}
