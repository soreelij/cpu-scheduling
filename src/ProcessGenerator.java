import java.util.Random;

public class ProcessGenerator implements ProcessGeneratorInterface {

    private double probability;
    private long seed;

    private Random random;

    public ProcessGenerator(double probability, long seed) {

        this.probability = probability;
        this.seed = seed;

        this.random = new Random(seed);


    }

    public ProcessGenerator(double probability) {

        this.probability = probability;
        this.random = new Random();


    }

    @Override
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {

        int processTime = (random.nextInt(maxProcessTime) + 1);
        int priority = (random.nextInt(maxPriority));

        Process process = new Process(currentTime, processTime, priority);

        return process;
    }

    @Override
    public boolean query() {

        double rate = random.nextDouble();

        if (rate < probability) {

            return true;

        } else {

            return false;

        }

    }

}
