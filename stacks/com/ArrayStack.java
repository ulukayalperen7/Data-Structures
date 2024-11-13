package stacks.com;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int pointer = 0; // index of top +1. element (also length = pointer)

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) (new Object[capacity]);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        data = (E[]) (new Object[CAPACITY]);
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[pointer - 1];
    }

    @Override
    public void push(E e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[pointer] = e;
        pointer++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E returnValue = data[pointer - 1];
        data[pointer - 1] = null;
        pointer--;
        return returnValue;
    }
}
