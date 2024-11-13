package singlyLinkedList.com;

public class SinglyLinked<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinked() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(head);
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            return null; // nothing to do
        }
        Node<E> returning = new Node<>(head.getElement());
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        size--;
        return returning.getElement();
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<E> traveller = head;
            while (traveller.getNext() != tail) {
                traveller = traveller.getNext();
            }
            traveller.setNext(null);
            tail = traveller;
        }
        size--;
    }

}
