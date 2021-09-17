import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode l2 = new TreeNode(7);
        TreeNode r2 = new TreeNode(9);
        TreeNode r1 = new TreeNode(8, l2, r2);

        TreeNode l11 = new TreeNode(0);

        TreeNode l111 = new TreeNode(3);
        TreeNode r111 = new TreeNode(5);

        TreeNode r11 = new TreeNode(4, l111, r111);
        TreeNode l1 = new TreeNode(2, l11, r11);

        TreeNode root = new TreeNode(6, l1, r1);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        System.out.println(solution.lowestCommonAncestor(root, p, q).val);

    }

}

