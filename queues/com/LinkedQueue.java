package queues.com;

import singlyLinkedList.com.SinglyLinked;

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinked<E> list = new SinglyLinked<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
