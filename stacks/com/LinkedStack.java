package stacks.com;

public class LinkedStack<E> implements Stack<E> {

    Node<E> top;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }

    @Override
    public void push(E e) {
        top = new Node<>(e, top);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

}
