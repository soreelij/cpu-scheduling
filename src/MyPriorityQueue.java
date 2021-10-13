public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

    @Override
    public void enqueue(Process p) {

        try {

            this.insert(p);

        } catch (HeapException e) {

            e.printStackTrace();

        }

    }

    @Override
    public Process dequeue() {

        try {

            return extractMax();

        } catch (HeapException e) {

            e.printStackTrace();
            return null;

        }

    }

    @Override
    public void update(Process next, int timeToIncrementPriority, int maxPriority) {

        for (int index = 0; index < size; index++) {

            heap[index].incrementWaitingTime();

            if (heap[index].getWaitingTime() >= timeToIncrementPriority) {

                heap[index].resetWaitingTime();

                if (heap[index].getPriority() < maxPriority) {

                    heap[index].setPriority(heap[index].getPriority() + 1);

                    try {

                        increaseKey(index, heap[index]);

                    } catch (HeapException e) {

                        e.printStackTrace();

                    }


                }

            }
        }

    }

}
