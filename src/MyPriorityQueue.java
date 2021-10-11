public class MyPriorityQueue extends MaxHeap<Process> implements PriorityQueueInterface {

    @Override
    public void enqueue(Process p) {
        this.insert(p);
    }

    @Override
    public Process dequeue() {
        return this.extractMax();
    }

    @Override
    public void update(Process next, int timeToIncrementPriority, int maxPriority) {

        next.resetWaitingTime();

        for (int index = this.size(); index > 0; index--) {

            int priority = heap[index].getPriority();
            heap[index].incrementWaitingTime();

            if (priority < maxPriority) {

                heap[index].setPriority(priority + 1);
                this.maxHeapify(index);

            }

        }

    }

}
