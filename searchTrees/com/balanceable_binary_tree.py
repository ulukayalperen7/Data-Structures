class BalanceableBinaryTree:
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

    class BSTNode(Node):
        
        def __init__(self, element, parent=None, left=None, right=None):
            super().__init__(element, parent, left, right)
            self.aux = 0

        def get_aux(self):
            return self.aux

        def set_aux(self, value):
            self.aux = value


    def __init__(self):
        self.root = None

    def create_node(self, element, parent, left, right):
        return self.BSTNode(element, parent, left, right)

    def get_aux(self, p):
        return p.get_aux()

    def set_aux(self, p, value):
        p.set_aux(value)

    def relink(self, parent, child, make_left_child):
        child.parent = parent
        if make_left_child:
            parent.left = child
        else:
            parent.right = child

    def rotate(self, p):
        x = p
        y = x.parent
        z = y.parent if y else None

        if z is None:
            self.root = x
            x.parent = None
        else:
            self.relink(z, x, y == z.left)

        if x == y.left:
            self.relink(y, x.right, True)
            self.relink(x, y, False)
        else:
            self.relink(y, x.left, False)
            self.relink(x, y, True)

    def restructure(self, x):
        y = x.parent
        z = y.parent

        if (x == y.right) == (y == z.right):
            self.rotate(y)
            return y
        else:
            self.rotate(x)
            self.rotate(x)
            return x
