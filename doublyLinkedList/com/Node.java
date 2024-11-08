package doublyLinkedList.com;

public class Node<E> {
    private Node<E> prev;
    private Node<E> next;
    private E element;

    public Node(E element) {
        this.prev = null;
        this.next = null;
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    public E getElement(){
        return element;
    }
}
