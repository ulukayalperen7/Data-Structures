package lists.com;

public class LinkedPositionalList<E> implements PositionalList<E> {
    private static class ListNode<E> implements Position<E> {
        private E element;
        private ListNode<E> prev;
        private ListNode<E> next;

        public ListNode(E element, ListNode<E> prev, ListNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() {
            return element;
        }

        public ListNode<E> getPrev() {
            return prev;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }

        public void setPrev(ListNode<E> prev) {
            this.prev = prev;
        }
    }

    private ListNode<E> header;
    private ListNode<E> trailer;
    private int size;

    // all methods work on O(1) running time
    
    public LinkedPositionalList() {
        header = new ListNode<>(null, null, null);
        trailer = new ListNode<>(null, header, null);
        header.setNext(trailer);
    }

    private ListNode<E> validate(Position<E> p) {
        if (!(p instanceof LinkedPositionalList.ListNode<E> node)) {
            throw new IllegalArgumentException("invalid p");
        }
        if (node.getNext() == null) {
            throw new IllegalArgumentException();
        }
        return node;
    }

    private Position<E> position(ListNode<E> node) {
        if (node == header || node == trailer) {
            return null;
        }
        return node;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first Position in the linked list (or null, if empty).
     */
    public Position<E> first() {
        return position(header.getNext());
    }

    /**
     * Returns the last Position in the linked list (or null, if empty).
     */
    public Position<E> last() {
        return position(trailer.getPrev());
    }


    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        return position(node.getPrev());
    }


    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        return position(node.getNext());
    }

    private Position<E> addBetween(E e, ListNode<E> pred, ListNode<E> succ) {
        ListNode<E> newest = new ListNode<>(e, pred, succ); // create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * Inserts element e at the front of the linked list and returns its new Position.
     */
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }


    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }


    public Position<E> addBefore(Position<E> p, E e)
            throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }


    public Position<E> addAfter(Position<E> p, E e)
            throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Replaces the element stored at Position p and returns the replaced element.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        ListNode<E> node = validate(p);
        ListNode<E> predecessor = node.getPrev();
        ListNode<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }
}
