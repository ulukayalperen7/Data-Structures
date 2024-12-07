package heaps.com;

import priorityqueue.com.AbstractPriorityQueue;
import priorityqueue.com.Entry;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {  // for natural ordering of its keys
        super();
    }

    public HeapPriorityQueue(Comparator<K> comparator) { // using comparator to order keys
        super(comparator);
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return i * 2 + 1;
    }

    public int right(int i) {
        return i * 2 + 2;
    }

    public boolean hasLeft(int i) {
        return left(i) < heap.size();
    }

    public boolean hasRight(int i) {
        return right(i) < heap.size();
    }

    private void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     */
    public void upHeap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    public void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChild = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChild = rightIndex; // right child is smaller
                }
            }
            if (compare(heap.get(smallChild), heap.get(j)) >= 0) { // already done
                break;
            }
            swap(j, smallChild);
            j = smallChild;
        }
    }

    public int size() {
        return heap.size();
    }

    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest); // add to end of the list
        upHeap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        return heap.get(0);
    }

    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> removed = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return removed;
    }
}
