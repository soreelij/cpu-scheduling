public class Process implements Comparable<Process>, ProcessInterface {

    private int priority;
    private int timeRemaining;
    private int arrivalTime;
    private int waitingTime;

    public Process(int arrivalTime, int timeRemaining, int priority, int waitingTime) {

        this.arrivalTime = arrivalTime;
        this.timeRemaining = timeRemaining;
        this.priority = priority;
        this.waitingTime = waitingTime;

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
        return timeRemaining == 0;
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
        } else if (this.priority == p.getPriority()) {
            return 0;
        } else return -1;

    }
}
