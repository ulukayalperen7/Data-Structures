package priorityqueue.com;

import heaps.com.HeapPriorityQueue;

import java.util.Comparator;

public class HeapAdaptablePriorityQueue<K extends Comparable<K>, V> extends HeapPriorityQueue<K, V> {

    static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index;

        public AdaptablePQEntry(K key, V value, int j) {
            super(key, value);
            index = j;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

    // natural ordering
    public HeapAdaptablePriorityQueue() {
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i); // reset entry's index
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
    }

    /**
     * Restores the heap property by moving the entry at index j upward/downward.
     */
    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0) {
            upHeap(j);
        } else {
            downHeap(j);
        }
    }

    // O(logn)
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {

        Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest); // add to the end of the list
        upHeap(heap.size() - 1); // upheap newly added entry
        return newest;
    }

    /**
     * Validates an entry to ensure it is location-aware.
     */
    private AdaptablePQEntry<K, V> validate(Entry<K, V> entry) {
        if (!(entry instanceof AdaptablePQEntry)) {
            throw new IllegalArgumentException("Invalid entry");
        }
        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry; // safe
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator)
            throw new IllegalArgumentException("Invalid entry");
        return locator;
    }

    public void remove(Entry<K, V> entry) { // O(logn)
        AdaptablePQEntry<K, V> locator = validate(entry);
        int j = locator.getIndex();
        if (j == heap.size() - 1) {// entry is at last position
            heap.remove(heap.size() - 1);
        } else {
            swap(j, heap.size() - 1);
        }
    }

    /**
     * Replaces the key of an entry.
     */
    public void replaceKey(Entry<K, V> entry, K key) {  // O(logn)
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    /**
     * Replaces the value of an entry.
     */
    public void replaceValue(Entry<K, V> entry, V value) {  // O(1)
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setValue(value);
    }


}
