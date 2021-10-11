// TODO
public class ProcessGenerator implements ProcessGeneratorInterface {

    private final int MIN = 1;

    private double probability;
    private long seed;

    boolean useSeed;

    public ProcessGenerator(double probability, long seed) {

        this.probability = probability;
        this.seed = seed;

        useSeed = true;

    }

    public ProcessGenerator(double probability) {

        this.probability = probability;

        useSeed = false;

    }

    @Override
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {

        int processTimeRange = (maxProcessTime - MIN) + 1;
        int priorityRange = (maxPriority - MIN) + 1;

        int processTime = (int) (Math.random() * processTimeRange) + MIN;
        int priority = (int) (Math.random() * priorityRange) + MIN;

        Process process = new Process(currentTime, processTime, priority, 0);

        return process;
    }

    @Override
    public boolean query() {

        int rate;

        if (useSeed) {
            rate = (int) ((Math.random() * seed) + probability);
        } else {
            rate = (int) ((Math.random()) + probability);
        }

        return rate >= 1;

    }

}
