package stacks.com;

public class Node<E> {
    E data;
    Node<E> next;

    Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {

        return data;
    }

    public void setNext(Node<E> next) {

        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }
}
