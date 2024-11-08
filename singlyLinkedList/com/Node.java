package singlyLinkedList.com;

public class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    protected E getElement() {
        return element;
    }

    protected Node<E> getNext() {
        return next;
    }

    protected void setNext(Node<E> newNode) {
        this.next = newNode;
    }
}
