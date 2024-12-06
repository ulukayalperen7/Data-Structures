package priorityqueue.com;

import lists.com.LinkedPositionalList;
import lists.com.Position;
import lists.com.PositionalList;

import java.util.Comparator;

public class SortedPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue() {
        super();
    }

    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public int size() {
        return 0;
    }

    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> move = list.last();
        while (move != null && compare(newest, move.getElement()) < 0) {
            move = list.before(move);
        }
        if (move == null) {
            list.addFirst(newest);
        } else {
            list.addAfter(move, newest);
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) {
            return null;
        }
        return list.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(list.first());
    }
}
