package trees.com;

import lists.com.Position;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 */
public interface Tree<E> extends Iterable<E> {

    Position<E> root();

    Position<E> parent(Position<E> p);

    Iterable<Position<E>> children(Position<E> p);

    int numChildren(Position<E> p);

    boolean isInternal(Position<E> p);

    boolean isExternal(Position<E> p);

    boolean isRoot(Position<E> p);

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
