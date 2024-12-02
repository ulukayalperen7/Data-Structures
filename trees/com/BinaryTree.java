package trees.com;

import lists.com.Position;

public interface BinaryTree<E> extends Tree<E> {

    /** Returns the Position of p's left child (or null if no child exists) */
    Position<E> left(Position<E> p);

    Position<E> right(Position<E> p);

    Position<E> sibling(Position<E> p);

}
