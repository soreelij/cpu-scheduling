// TODO
public class Process implements Comparable, ProcessInterface {

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void setPriority(int priority) {

    }

    @Override
    public int getTimeRemaining() {
        return 0;
    }

    @Override
    public void decrementTimeRemaining() {

    }

    @Override
    public boolean finished() {
        return false;
    }

    @Override
    public int getArrivalTime() {
        return 0;
    }

    @Override
    public int getWaitingTime() {
        return 0;
    }

    @Override
    public void incrementWaitingTime() {

    }

    @Override
    public void resetWaitingTime() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
