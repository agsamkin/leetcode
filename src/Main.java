import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

//        ListNode list1 = new ListNode(1);
//        ListNode list2 = new ListNode(2);
//        list1.next = list2;

        System.out.println(solution.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

    }

}

