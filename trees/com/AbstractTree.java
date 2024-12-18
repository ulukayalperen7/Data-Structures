package trees.com;

import lists.com.Position;
import queues.com.LinkedQueue;
import queues.com.Queue;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {  // the depth is the number of ancestors of p, other than p itself
        if (isRoot(p)) {
            return 0;
        }
        return 1 + depth(parent(p));
    }

    private int height() {    // O(n'2)
        int height = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) {
                height = Math.max(height, depth(p));
            }
        }
        return height;
    }

    public int heightBetter(Position<E> p) {   // O(n)
        int height = 0;
        for (Position<E> l : children(p)) {
            height = Math.max(height, 1 + heightBetter(l));
        }
        return height;
    }

    //    PREORDER
    /*    basic

    public void preOrder(int index) {
        if (index >= size || tree[index] == null) {
            return; // Base case: out of bounds or null node
        }

        // Visit the root node
        System.out.print(tree[index] + " ");

        // Recursively visit the left child
        preOrder(2 * index + 1);

        // Recursively visit the right child
        preOrder(2 * index + 2);
    }*/

    public Iterable<Position<E>> positions() {
        return preorder();
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }


    // POSTORDER
   /*
    public void postOrder(int index) {
        if (index >= size || tree[index] == null) {
            return; // Base case: out of bounds or null node
        }

        // Recursively visit the left child
        postOrder(2 * index + 1);

        // Recursively visit the right child
        postOrder(2 * index + 2);

        // Visit the root node
        System.out.print(tree[index] + " ");
    }*/

    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }

    // BREADTH-FIRST

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c : children(p))
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }
}
