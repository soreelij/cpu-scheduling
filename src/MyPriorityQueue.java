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
    public void increaseKey(int position, int key) {

        if (key < heap[position].getPriority()) {
            // TODO: fix exception
            // throw new HeapException("Key is smaller than current key");
            return;
        }

        int parent = parent(position);

        heap[position].setPriority(key);

        while (position > 1 && heap[parent].getPriority() < heap[position].getPriority()) {

            swap(position, parent);
            position = parent(position);

        }

    }

    @Override
    public void update(Process next, int timeToIncrementPriority, int maxPriority) {

        next.resetWaitingTime();

        for (int index = this.size(); index > 0; index--) {

            int priority = heap[index].getPriority();
            int waitingTime = heap[index].getWaitingTime();

            heap[index].incrementWaitingTime();

            if (waitingTime >= timeToIncrementPriority) {

                heap[index].resetWaitingTime();

                if (priority < maxPriority) {

                    priority++;

                    increaseKey(index, (priority));

                }

            }

        }

    }

}
