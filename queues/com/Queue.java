package queues.com;

public interface Queue<E> {
    public int size();

    public boolean isEmpty();

    public void enqueue(E e);

    public E dequeue();

}
