package priorityqueue.com;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

    static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Comparator<K> comparator;

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     */
    public AbstractPriorityQueue(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    public int compare(Entry<K, V> a, Entry<K, V> b) {
        return comparator.compare(a.getKey(), b.getKey());
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}

class DefaultComparator<E extends Comparable<E>> implements Comparator<E> {

    @Override
    public int compare(E a, E b) throws ClassCastException {
        return a.compareTo(b);
    }
}
