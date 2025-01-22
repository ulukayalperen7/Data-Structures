class TreeNode:
   
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.left = None
        self.right = None

class TreeMap:
    
    def __init__(self):
        self.root = None

    def get(self, key):
        return self._tree_search(self.root, key)


    def _tree_search(self, node, key):
        if node is None:
            return None
        if key == node.key:
            return node.value
        elif key < node.key:
            return self._tree_search(node.left, key)
        else:
            return self._tree_search(node.right, key)

    def put(self, key, value):
        self.root = self._tree_insert(self.root, key, value)

    def _tree_insert(self, node, key, value):
        
        if node is None:
            return TreeNode(key, value)
        if key < node.key:
            node.left = self._tree_insert(node.left, key, value)
        elif key > node.key:
            node.right = self._tree_insert(node.right, key, value)
        else:
            node.value = value  
        return node

    def remove(self, key):
    
        self.root = self._tree_remove(self.root, key)

    def _tree_remove(self, node, key):
   
        if node is None:
            return None
        if key < node.key:
            node.left = self._tree_remove(node.left, key)
        elif key > node.key:
            node.right = self._tree_remove(node.right, key)
        else:
            if node.left is None:  
                return node.right
            elif node.right is None: 
                return node.left
            min_larger_node = self._get_min(node.right)
            node.key, node.value = min_larger_node.key, min_larger_node.value
            node.right = self._tree_remove(node.right, min_larger_node.key)
        return node

    def _get_min(self, node):
        while node.left is not None:
            node = node.left
        return node

    def inorder(self):
        result = []
        self._inorder(self.root, result)
        return result

    def _inorder(self, node, result):
        if node is not None:
            self._inorder(node.left, result)
            result.append((node.key, node.value))
            self._inorder(node.right, result)
# usage 
tree_map = TreeMap()
tree_map.put(10, "A")
tree_map.put(20, "B")
tree_map.put(5, "C")
print(tree_map.get(10))  
tree_map.remove(10)
print(tree_map.get(10))  
print(tree_map.inorder())  
