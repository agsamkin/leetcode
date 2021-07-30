import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // [1,2,2,3,null,null,3,4,null,null,4]

        TreeNode r5 = new TreeNode(4);
        TreeNode r3 = new TreeNode(3, null, r5);

        TreeNode l4 = new TreeNode(4);
        TreeNode l2 = new TreeNode(3, l4, null);

        TreeNode r1 = new TreeNode(2, null, r3);
        TreeNode l1 = new TreeNode(2, l2, null);

        TreeNode root = new TreeNode(1, l1, r1);

        System.out.println(solution.isBalanced(root));

    }

}
