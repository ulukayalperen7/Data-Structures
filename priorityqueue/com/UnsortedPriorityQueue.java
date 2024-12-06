package priorityqueue.com;

import lists.com.LinkedPositionalList;
import lists.com.Position;

import java.util.Comparator;

public class UnsortedPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

    private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    private Position<Entry<K, V>> findMin() {
        Position<Entry<K, V>> small = list.first();

        for (Position<Entry<K, V>> move : list.positions()) {
            if (compare(move.getElement(), small.getElement()) < 0) {
                small = move;
            }
        }
        return small;
    }

    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return findMin().getElement();
    }

    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(findMin());
    }

    public int size() {
        return list.size();
    }
}
