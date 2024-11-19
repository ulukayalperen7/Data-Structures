package circularSinglyLinkedList.com;

public class CircularSinglyLinkedList<E> {
    private int size;
    private Node<E> last;

    public CircularSinglyLinkedList() {
        size = 0;
        last = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            last = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<E> current = last.getNext(); // first node
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != last.getNext());
    }

    public void clearList() {
        last = null;
        size = 0;
    }

    public void removeFirst() {
        if ((isEmpty())) {
            System.out.println("List is empty");
            return;
        }
        if (getSize() == 1) {
            last = null;
        } else {
            last.setNext(last.getNext().getNext());
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (getSize() == 1) {
            last = null;
        } else {
            Node<E> current = last.getNext();
            while (current.getNext() != last) {
                current = current.getNext();
            }
            current.setNext(last.getNext());
            last = current;
        }
        size--;
    }
}

class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public E getData() {
        return data;
    }

}
