package doublyLinkedList.com;

public class DoublyLinked<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinked() {
        head = null;
        tail = null;
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

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setNext(null);
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
    }

    public void remove(Node<E> node) {
        if (node == null || isEmpty()) {
            return;
        }
        if (node == head) {
            removeFirst();
        } else if (node == tail) {
            removeLast();
        } else {
            Node<E> predecessor = node.getPrev();
            Node<E> succesor = node.getNext();
            if (predecessor != null) {
                predecessor.setNext(succesor);
            }
            if (succesor != null) {
                succesor.setPrev(predecessor);
            }
            size--;
        }
    }

    public void addBetween(E element, Node<E> predecessor, Node<E> succesor) {
        Node<E> newNode = new Node<>(element);
        newNode.setPrev(predecessor);
        newNode.setNext(succesor);
        predecessor.setNext(newNode);
        succesor.setPrev(newNode);
        size++;
    }

}
