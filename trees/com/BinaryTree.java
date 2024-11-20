package trees.com;

import java.util.Stack;

public class BinaryTree<E> {

    private TreeNode<E> root;

    public void preOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void preOrderWithStack(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> temp = stack.pop();
            System.out.println(temp.getData());
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
    }
}
