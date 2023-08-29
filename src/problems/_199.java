package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _199 {
    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root.right != null) {
            return List.of();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                }
            }
        }
        return result;
    }



}
