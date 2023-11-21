package Laboratory3.Queues;

import java.util.PriorityQueue;
import java.util.NoSuchElementException;

public class MinHeapQueue<E extends Comparable<E>> implements Queue<E> {
    private final PriorityQueue<E> priorityQueue;
    private static final int MAX_CAPACITY = 5;

    public MinHeapQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void enqueue(E item) {
        if (size() == MAX_CAPACITY) {
            throw new IllegalStateException("Queue is full.");
        }
        priorityQueue.offer(item);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return priorityQueue.poll();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return priorityQueue.peek();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public void clear() {
        priorityQueue.clear();
    }
}
