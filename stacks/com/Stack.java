package stacks.com;

public interface Stack<E> {
    public int size();

    public boolean isEmpty();

    public E top();

    public void push(E e);

    public E pop();
}
