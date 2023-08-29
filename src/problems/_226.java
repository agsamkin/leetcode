package problems;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            if (node.left != null && node.right != null) {
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = tmp;
            } else if (node.left != null) {
                TreeNode tmp = node.left;
                node.left = null;
                node.right = tmp;
            } else if (node.right != null) {
                TreeNode tmp = node.right;
                node.right = null;
                node.left = tmp;
            }
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        return root;
    }
}

