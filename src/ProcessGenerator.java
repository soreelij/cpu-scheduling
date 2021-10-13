import java.util.Random;

/**
 * Random <code>Process</code> generator for insertion into
 * a <code>PriorityQueue/code> to simulate CPU scheduling
 * and process-handling algorithms. Accepts a long <code>seed</code>
 * value for testing purposes.
 *
 * @author Elijah Sorensen
 * @version CS321: Fall 2021
 */
public class ProcessGenerator implements ProcessGeneratorInterface {

    private double probability;
    private long seed;

    private Random random;

    /**
     * Builds a new <code>ProcessGenerator</code>.
     *
     * @param probability the rate at which to generate
     *                    new <code>Process</code> objects
     * @param seed the input value to return the same
     *             pseudorandom values for testing purposes
     */
    public ProcessGenerator(double probability, long seed) {

        this.probability = probability;
        this.seed = seed;

        this.random = new Random(seed);

    }

    /**
     * Builds a new, random <code>ProcessGenerator</code>.
     *
     * @param probability the rate at which to generate
     *                    new <code>Process</code> objects
     */
    public ProcessGenerator(double probability) {

        this.probability = probability;
        this.random = new Random();

    }

    @Override
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {

        int priority =  random.nextInt(maxPriority) + 1;
        int processTime = random.nextInt(maxProcessTime) + 1;

        Process process = new Process(currentTime, processTime, priority);

        return process;
    }

    @Override
    public boolean query() {

        double rate = random.nextDouble();

        return rate < probability;

    }

}
