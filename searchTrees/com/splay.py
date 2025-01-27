class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.parent = None
        self.left = None
        self.right = None


class SplayTreeMap:
    def __init__(self):
        self.root = None

    def rotate_right(self, x):
        y = x.left
        x.left = y.right
        if y.right:
            y.right.parent = x
        y.parent = x.parent
        if x.parent is None:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y
        y.right = x
        x.parent = y

    def rotate_left(self, x):
        y = x.right
        x.right = y.left
        if y.left:
            y.left.parent = x
        y.parent = x.parent
        if x.parent is None:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y
        y.left = x
        x.parent = y

    def splay(self, x):
        while x.parent:
            if not x.parent.parent:
                if x == x.parent.left:
                    self.rotate_right(x.parent)
                else:
                    self.rotate_left(x.parent)
            elif x == x.parent.left and x.parent == x.parent.parent.left:
                self.rotate_right(x.parent.parent)
                self.rotate_right(x.parent)
            elif x == x.parent.right and x.parent == x.parent.parent.right:
                self.rotate_left(x.parent.parent)
                self.rotate_left(x.parent)
            elif x == x.parent.right and x.parent == x.parent.parent.left:
                self.rotate_left(x.parent)
                self.rotate_right(x.parent)
            else:
                self.rotate_right(x.parent)
                self.rotate_left(x.parent)

    def insert(self, key, value):
        node = self.root
        parent = None
        while node:
            parent = node
            if key < node.key:
                node = node.left
            elif key > node.key:
                node = node.right
            else:
                node.value = value
                self.splay(node)
                return
        new_node = Node(key, value)
        new_node.parent = parent
        if parent is None:
            self.root = new_node
        elif key < parent.key:
            parent.left = new_node
        else:
            parent.right = new_node
        self.splay(new_node)

    def find(self, key):
        node = self.root
        while node:
            if key < node.key:
                node = node.left
            elif key > node.key:
                node = node.right
            else:
                self.splay(node)
                return node.value
        return None

    def delete(self, key):
        node = self.root
        while node:
            if key < node.key:
                node = node.left
            elif key > node.key:
                node = node.right
            else:
                self.splay(node)
                if not node.left:
                    self.replace(node, node.right)
                elif not node.right:
                    self.replace(node, node.left)
                else:
                    min_node = self.subtree_min(node.right)
                    if min_node.parent != node:
                        self.replace(min_node, min_node.right)
                        min_node.right = node.right
                        min_node.right.parent = min_node
                    self.replace(node, min_node)
                    min_node.left = node.left
                    min_node.left.parent = min_node
                return
        return None

    def replace(self, u, v):
        if u.parent is None:
            self.root = v
        elif u == u.parent.left:
            u.parent.left = v
        else:
            u.parent.right = v
        if v:
            v.parent = u.parent

    def subtree_min(self, node):
        while node.left:
            node = node.left
        return node
