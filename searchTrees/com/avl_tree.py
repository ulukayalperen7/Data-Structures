class AVLTreeMap:
    class Entry:
        def __init__(self, key, value):
            self.key = key
            self.value = value

    class Node:
        def __init__(self, element, parent=None, left=None, right=None):
            self.element = element
            self.parent = parent
            self.left = left
            self.right = right
            self.aux = 0

    def __init__(self, comparator=None):
        self.tree = None
        self.comparator = comparator

    def height(self, p):
        return p.aux

    def recompute_height(self, p):
        p.aux = 1 + max(self.height(p.left), self.height(p.right))

    def is_balanced(self, p):
        return abs(self.height(p.left) - self.height(p.right)) <= 1

    def taller_child(self, p):
        if self.height(p.left) > self.height(p.right):
            return p.left
        elif self.height(p.left) < self.height(p.right):
            return p.right
        if self.is_root(p):
            return p.left
        if p == p.parent.left:
            return p.left
        else:
            return p.right

    def rebalance(self, p):
        old_height, new_height = None, None
        while old_height != new_height and p is not None:
            old_height = self.height(p)
            if not self.is_balanced(p):
                p = self.restructure(self.taller_child(self.taller_child(p)))
                self.recompute_height(p.left)
                self.recompute_height(p.right)
            self.recompute_height(p)
            new_height = self.height(p)
            p = p.parent

    def rebalance_insert(self, p):
        self.rebalance(p)

    def rebalance_delete(self, p):
        if not self.is_root(p):
            self.rebalance(p.parent)

    def is_root(self, p):
        return p.parent is None

    def restructure(self, p):
        pass
