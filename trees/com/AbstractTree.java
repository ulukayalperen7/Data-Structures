package trees.com;

import lists.com.Position;

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
}
