package trees.com;

public class ArrayBasedBinaryTree<E> {
    private E[] tree;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayBasedBinaryTree(int capacity) {
        this.tree = (E[]) new Object[capacity];
    }

    public void add(E value) {
        if (getCapacity() == getSize()) {
            throw new IllegalStateException("the tree is full");
        }
        tree[size] = value;
        size++;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public E getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left >= size) {
            return null; // no left child
        }
        return tree[left];
    }

    public E getRightChild(int index) {
        int right = 2 * index + 2;
        if (right >= size) {
            return null;
        }
        return tree[right];
    }

    public E getParent(int index) {
        int parent = (index - 1) / 2;
        if (index <= 0 || index >= size) {
            return null;
        }
        return tree[parent];
    }

    public void displayTree() {
        for (int i = 0; i < size; i++) {
            System.out.println(tree[i] +" ");
        }
        System.out.println();
    }
}
