package trees.com;

import lists.com.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * Returns an iterable collection of the Positions representing p's children.
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    public Iterable<Position<E>> positions() {
        return inorder();
    }

    /*public void inOrder(int index) {
        if (index >= size || tree[index] == null) {
            return; // Base case: out of bounds or null node
        }

        // Recursively visit the left child
        inOrder(2 * index + 1);

        // Visit the root node
        System.out.print(tree[index] + " ");

        // Recursively visit the right child
        inOrder(2 * index + 2);
    }*/
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }


}
