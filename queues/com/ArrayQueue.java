package queues.com;

public class ArrayQueue<E> implements Queue<E> {
    private int capacity;
    private E[] data;
    private int front =0;
    private int sizeOfQueue =0;


    public ArrayQueue() {
        this(1000);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return sizeOfQueue;
    }

    @Override
    public boolean isEmpty() {
        return sizeOfQueue == 0;
    }

    @Override
    public void enqueue(E e) {
        if (sizeOfQueue == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (front + sizeOfQueue) % data.length;
        data[avail] = e;
        sizeOfQueue++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E retValue = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        sizeOfQueue--;
        return retValue;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }
}
