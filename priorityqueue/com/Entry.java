package priorityqueue.com;

public interface Entry<K, V> {
    K getKey();

    V getValue();
}
