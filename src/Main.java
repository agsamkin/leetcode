import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//
//        //[3,2,0,-4]
//        ListNode listNode4 = new ListNode(-4);
//        ListNode listNode3 = new ListNode(0, listNode4);
//        ListNode listNode2 = new ListNode(2, listNode3);
//        ListNode listNode1 = new ListNode(3, listNode2);
//
//        listNode4.next = listNode2;
//
//        System.out.println(solution.hasCycle(listNode1));

        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}
