import javax.sound.midi.Soundbank;
import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Solution {

    //region 1. Two Sum
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int tmp = target - nums[i];
            if (numsMap.containsKey(tmp)) {
                int val = numsMap.get(tmp);
                res[0] = val;
                res[1] = i;
                break;
            }

            numsMap.put(nums[i], i);

        }

        return res;

    }
    //endregion

    //region 7. Reverse Integer
    public int reverse(int x) {

        int rev = 0;
        while (x!=0) {

            int pop = x % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            x /= 10;
            rev = rev * 10 + pop;

        }
        return rev;

    }
    //endregion

    //region 9. Palindrome Number
    public boolean isPalindrome(int x) {

        if (x ==0) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        int rev = reverse(x);

        if (rev == 0) {
            return false;
        }

        return (x == rev);

    }
    //endregion

    //region 13. Roman to Integer
    public int romanToInt(String s) {

        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0;

        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int x1 = romanMap.get(str[i]);
            int x2 = 0;
            if ((i+1) < s.length()) {
                x2 = romanMap.get(str[i+1]);
            }
            if (x1 < x2) {
                res = res - x1;
            } else {
                res = res + x1;
            }
        }

        return res;

    }
    //endregion

    //region 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];

        if (strs.length == 1) {
            return res;
        }

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length()-1);
                if (res.isEmpty()) {
                    return "";
                }
            }
        }

        return res;
    }
    //endregion

    //region 20. Valid Parentheses
    public boolean isValid(String s) {

        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (!brackets.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if (top!=brackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
    //endregion

    //region 21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode();

        if (l1.val < l2.val) {
            res.val = l1.val;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res.val = l2.val;
            res.next = mergeTwoLists(l2.next, l1);
        }

        return res;

    }
    //endregion

    //region 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {

        int res = 0;

        Set<Integer> set = new HashSet<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            int tmp = nums[i];

            if (set.contains(tmp)) {
                continue;
            } else {
                nums[j] = tmp;
                set.add(tmp);
                j++;
            }

        }

        return set.size();

    }
    //endregion

    //region 27. Remove Element
    public int removeElement(int[] nums, int val) {

        int res = nums.length;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            int tmp = nums[i];
            if (tmp == val) {
                res--;
                continue;
            } else {
                nums[j++] = tmp;
            }
        }

        return res;

    }
    //endregion

    //region 28. Implement strStr()
    public int strStr(String haystack, String needle) {

        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }

        char[] arr = haystack.toCharArray();

        for (int left = 0; left < arr.length - needle.length() + 1; left++) {

            if (haystack.substring(left, left+needle.length()).equals(needle)) {
                return left;
            }

        }

        return -1;

    }
    //endregion

    //region 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length;

        while (left <= right) {

            int split = (right + left) / 2;

            if (split >= nums.length) {
                return left;
            }

            int tmp = nums[split];

            if (tmp == target) {return split;}

            if (tmp > target) {
                right = split-1;
            } else {
                left = split+1;
            }

        }

        return left;

    }
    //endregion

    //region 53. Maximum Subarray
    public int maxSubArray(int[] nums) {

        if (nums.length==0) {return 0;}

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum > max) {
                max = sum;
            }
            for (int i1 = i+1; i1 < nums.length; i1++) {
                sum = sum + nums[i1];
                if(sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
    //endregion

    //region 58. Length of Last Word
    public int lengthOfLastWord(String s) {

        String[] arr = s.split(" ");

        if (arr.length == 0) {
            return 0;
        } else {
            return arr[arr.length-1].toCharArray().length;
        }

    }
    //endregion

    //region 66. Plus One
    public int[] plusOne(int[] digits) {

        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        for (int i = digits.length; i > 0; i--) {

            int tmp = digits[i-1];
            if(i == digits.length) {
                tmp++;
            }

            tmp += count;

            if (tmp > 9) {
                tmp = 0;
                count = 1;
            } else {
                count = 0;
            }

            list.add(0, tmp);
        }

        if (count > 0) {
            list.add(0,1);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;

    }
    //endregion

    //region 67. Add Binary
    public String addBinary(String a, String b) {

        if (a.length() > b.length()) {
            int tmp = a.length() - b.length();
            for (int i = 0; i < tmp; i++) {
                b = "0" + b;
            }
        }

        if (a.length() < b.length()) {
            int tmp = b.length() - a.length();
            for (int i = 0; i < tmp; i++) {
                a = "0" + a;
            }
        }

        int length = a.length();

        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();

        String res = "";
        boolean needAdd = false;

        for(int i = length; i > 0; i--) {

            char char_a = ' ';
            char char_b = ' ';

            char_a = chars_a[i-1];
            char_b = chars_b[i-1];

            char char_c = ' ';

            if (char_a == '1' && char_b == '1' && needAdd) {
                char_c = '1';
                needAdd = true;
            } else if (char_a == '1' && char_b == '1') {
                char_c = '0';
                needAdd = true;
            } else if (char_a == '0' && char_b == '0' && needAdd) {
                char_c = '1';
                needAdd = false;
            } else if (char_a == '0' && char_b == '0') {
                char_c = '0';
                needAdd = false;
            } else if (char_a == '0' && char_b == '1' && needAdd || char_a == '1' && char_b == '0' && needAdd) {
                char_c = '0';
                needAdd = true;
            } else if (char_a == '0' && char_b == '1' || char_a == '1' && char_b == '0') {
                char_c = '1';
                needAdd = false;
            } else {
                char_c = '0';
                needAdd = false;
            }

            res = char_c + res;

        }

        if (needAdd) {
            res = "1" + res;
        }

        return res;

    }
    //endregion

    //region 69. Sqrt(x)
    public int mySqrt(int x) {

        int res = 0;

        int min = 1;
        int max = x%2 == 0 ? x/2 : (x/2)+1;

        while (max>=min) {

            int mid = (min+max)/2;

            if (mid>Integer.MAX_VALUE/mid) {
                max = mid-1;
                continue;
            }

           int tmp = mid*mid;

           if (tmp==x) {res = mid; break;}
           if (tmp>x) {max = mid-1;}
           if (tmp<x) {min = mid+1;}

        }

        if (res == 0) {
            res = min-1;
        }

        return res;

    }
    //endregion

    //region 70. Climbing Stairs
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int climbStairs(int n) {

//        if (n==1) {return 1;}
//        else if (n==2) {return 2;}
//        else if (hashMap.containsKey(n)) {
//            return hashMap.get(n);
//        }
//        else {
//            int tmp = climbStairs(n-1) + climbStairs(n-2);
//            hashMap.put(n, tmp);
//            return tmp;
//        }

        hashMap.put(1, 1);
        hashMap.put(2, 2);

        int res = 0;
        for (int i = 3; i <= n; i++) {
            int tmp = hashMap.get(i-1) + hashMap.get(i-2);
            hashMap.put(i, tmp);
        }

        return hashMap.get(n);

    }
    //endregion

    //region 83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();

        ListNode lastNode = null;
        ListNode newHead = head;
        while (newHead.next != null) {

            if (set.contains(newHead.val)) {
                lastNode.next = newHead.next;
            } else {
                lastNode = newHead;
                set.add(newHead.val);
            }

            newHead = newHead.next;

        }

        if (lastNode!= null && set.contains(newHead.val)) {
            lastNode.next = null;
        }

        return head;

    }
    //endregion

    //region 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length == 0) {
            return;
        }

        int nn = n - 1;
        int mm = m - 1;
        for (int i = nums1.length-1; i >= 0; i--) {

            if (nn < 0 && mm >= 0) {
                nums1[i] = nums1[mm];
                mm--;
                continue;
            }

            if (mm < 0 && nn >= 0) {
                nums1[i] = nums2[nn];
                nn--;
                continue;
            }

            if (nums1[mm] > nums2[nn]) {
                nums1[i] = nums1[mm];
                mm--;
            } else {
                nums1[i] = nums2[nn];
                nn--;
            }

        }

    }
    //endregion

    //region 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) { return res; }

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;

    }
    //endregion

    //region 100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean res = false;

        if (p == null & q == null) {
            return true;
        }

        if (p != null && q != null) {

            if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                res = true;
            }

        }

        return res;

    }
    //endregion

    //region 101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {

        boolean res = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                res = false;
                break;
            }

            if (left.val != right.val) {
                res = false;
                break;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);

        }

        return res;

    }
    //endregion

    //region 104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        res++;
        res = res + Math.max(maxDepth(root.left), maxDepth(root.right));

        return res;

    }
    //endregion

    //region 108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {return null;}

        int mid = nums.length/2;
        int[] l = Arrays.copyOfRange(nums, 0, mid);
        int[] r = Arrays.copyOfRange(nums, mid+1, nums.length);
        TreeNode root = new TreeNode(nums[mid], sortedArrayToBST(l), sortedArrayToBST(r));

        return root;

    }
    //endregion

    //region 110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {

        boolean res = false;

        if (root == null) {return true;}

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        if (l>r) {
            res = (l-r) <= 1;
        } else {
            res = (r-l) <= 1;
        }

        if(res && isBalanced(root.left) && isBalanced(root.right)) {
            res = true;
        } else {res = false;}

        return res;

    }
    //endregion

    //region 111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        res++;

        if(root.left == null || root.right == null) {
            if(root.left == null) {
                res = res + minDepth(root.right);
            } else {
                res = res + minDepth(root.left);
            }
        } else {
            res = res + Math.min(minDepth(root.left), minDepth(root.right));
        }

        return res;

    }
    //endregion

    //region 112. Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        targetSum = targetSum - root.val;

        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
        
    }
    //endregion

    //region 118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {

        List rows = new LinkedList();
        List<Integer> lastRow = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new LinkedList<>();

            for (int j = 0; j < i; j++) {
                int tmp = 1;
                if (j > 0) {
                    tmp = lastRow.get(j-1) + lastRow.get(j);
                }
                row.add(tmp);
            }
            row.add(1);
            rows.add(row);
            lastRow = row;

        }

        return rows;

    }
    //endregion

    //region 119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {

        List<Integer> lastRow = new LinkedList<>();

        for (int i = 0; i < rowIndex; i++) {

            List<Integer> row = new LinkedList<>();

            for (int j = 0; j < i; j++) {
                int tmp = 1;
                if (j > 0) {
                    tmp = lastRow.get(j-1) + lastRow.get(j);
                }
                row.add(tmp);
            }
            row.add(1);
            lastRow = row;

        }

        return lastRow;

    }
    //endregion

    //region 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i];
            if (tmp > min) {
                maxProfit = Math.max(maxProfit, (tmp-min));
            } else {
                min = tmp;
            }

        }

        return maxProfit;

    }
    //endregion

    //region 122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int tmp = prices[i];
            if (tmp > min) {
                maxProfit = maxProfit + (tmp-min);
            }
            min = tmp;

        }

        return maxProfit;

    }
    //endregion

    //region 125. Valid Palindrome
    public boolean isPalindrome(String s) {

        boolean res = true;

        s = s.replaceAll("[^a-zA-ZА-Яа-я0-9\\s]", "").replace(" ", "").toLowerCase();

        int mid = s.length()/2;
        char[] arr = s.toCharArray();
        for (int i = 0; i < mid; i++) {
            if (arr[i] != arr[arr.length-i-1]) {
                res = false;
                break;
            }
        }

        return res;

    }
    //endregion

    //region 136. Single Number
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
    //endregion

    //region 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            ListNode currentNode = head.next;
            if (set.contains(currentNode)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;

    }
    //endregion

    //region 144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;

    }
    //endregion

    //region 145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;

    }
    //endregion

    //region 160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        Set<ListNode> set = new HashSet<>();
//        set.add(headA);
//
//        while (headA.next != null) {
//            set.add(headA.next);
//            headA = headA.next;
//        }
//
//        if (set.contains(headB)) {
//            return headB;
//        }
//
//        set.add(headB);
//        while (headB.next != null) {
//            if (set.contains(headB.next)) {
//                return headB.next;
//            }
//            set.add(headB.next);
//            headB = headB.next;
//        }

//        return null;

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }

        }

        return b;
    }
    //endregion

    //region 167. Two Sum II - Input array is sorted
    public int[] twoSum2(int[] numbers, int target) {

        int[] res = new int[2];

        if (numbers.length < 1) {
            return res;
        }

        int left = 0;
        int right = numbers.length-1;

        while (left<right) {

            int tmp = numbers[left] + numbers[right];

            if (tmp == target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }

            if (tmp > target) {
                right--;
            } else {
                left++;
            }

        }

        return res;

    }
    //endregion

    //region 168. Excel Sheet Column Title
    public String convertToTitle(int columnNumber) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        hashMap.put(5, "E");
        hashMap.put(6, "F");
        hashMap.put(7, "G");
        hashMap.put(8, "H");
        hashMap.put(9, "I");
        hashMap.put(10, "J");
        hashMap.put(11, "K");
        hashMap.put(12, "L");
        hashMap.put(13, "M");
        hashMap.put(14, "N");
        hashMap.put(15, "O");
        hashMap.put(16, "P");
        hashMap.put(17, "Q");
        hashMap.put(18, "R");
        hashMap.put(19, "S");
        hashMap.put(20, "T");
        hashMap.put(21, "U");
        hashMap.put(22, "V");
        hashMap.put(23, "W");
        hashMap.put(24, "X");
        hashMap.put(25, "Y");
        hashMap.put(26, "Z");

        String res = "";

        if (columnNumber <= 26) {
            return hashMap.get(columnNumber);
        }

        int tmp1 = (columnNumber-1)/26;

        if (tmp1 > 0 && tmp1 <= 26) {
            res = res + hashMap.get(tmp1);
        } else {
            res = res + convertToTitle(tmp1);
        }

        columnNumber = columnNumber - tmp1*26;

        if (columnNumber > 0) {
            res = res + hashMap.get(columnNumber);
        }

        return res;

    }
    //endregion

    //region 169. Majority Element
    public int majorityElement(int[] nums) {

        int res = 0;
        int n = nums.length%2 == 0 ? nums.length/2 : nums.length/2 + 1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i])+1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        Iterator iter = (Iterator) hashMap.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry)iter.next();
            if ((int) pair.getValue() >= n) {
                res = (int) pair.getKey();
                break;
            }

        }
        
        return res;

    }
    //endregion

    //region 171. Excel Sheet Column Number
    public int titleToNumber(String columnTitle) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 1);
        hashMap.put('B', 2);
        hashMap.put('C', 3);
        hashMap.put('D', 4);
        hashMap.put('E', 5);
        hashMap.put('F', 6);
        hashMap.put('G', 7);
        hashMap.put('H', 8);
        hashMap.put('I', 9);
        hashMap.put('J', 10);
        hashMap.put('K', 11);
        hashMap.put('L', 12);
        hashMap.put('M', 13);
        hashMap.put('N', 14);
        hashMap.put('O', 15);
        hashMap.put('P', 16);
        hashMap.put('Q', 17);
        hashMap.put('R', 18);
        hashMap.put('S', 19);
        hashMap.put('T', 20);
        hashMap.put('U', 21);
        hashMap.put('V', 22);
        hashMap.put('W', 23);
        hashMap.put('X', 24);
        hashMap.put('Y', 25);
        hashMap.put('Z', 26);

        char[] arr = columnTitle.toCharArray();

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (i == (arr.length-1)) {
                res = res + hashMap.get(c);
            } else {
                res = (res + hashMap.get(c))*26;
            }
        }

        return res;

    }
    //endregion

    //region 172. Factorial Trailing Zeroes
    public int trailingZeroes(int n) {

        int res = 0;
        while (n>0) {
            n = n / 5;
            res = res + n;
        }

        return res;

    }
    //endregion

    //region 190. Reverse Bits
    public int reverseBits(int n) {

        String s1 = Integer.toBinaryString(n);
        String s2 = new StringBuffer(s1).reverse().toString();
        return 0;

    }
    //endregion

    //region 202. Happy Number
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {

        char[] arr = Integer.toString(n).toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = Integer.parseInt(Character.toString(arr[i]));
            res = res + tmp*tmp;
        }

        if (res == 1) {
            return true;
        }

        if (set.contains(res)) {
            return false;
        }

        set.add(res);
        return isHappy(res);

    }
    //endregion

    //region 203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {

        ListNode res = null;

        if (head == null) {
            return res;
        }

        ListNode oldHead = null;

        while (head != null) {
            if (head.val == val && oldHead != null) {
                oldHead.next = head.next;
            }
            if (head.val != val) {
                oldHead = head;
            }
            if (head.val != val && res == null) {
                res = head;
            }
            head = head.next;
        }

        return res;

    }
    //endregion

    //region 204. Count Primes
    public int countPrimes(int n) {

        boolean[] notPrimes = new boolean [n];
        if (n <= 2) return 0;

        int count = 1; //initializing that 2 is prime

        for (int i = 3; i < n; i += 2) { //skipping all even numbers
            if (!notPrimes[i]) {
                count++;

                for (int j = 1; j*i < n; j++) { //all multiples of the prime number are not primes
                    notPrimes[j*i] = true;
                }
            }
        }

        return count;

    }
    //endregion

    //region 205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private String transformString(String s) {

        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }

            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append("_");
        }
        String tmp = builder.toString();
        //System.out.println(tmp);
        return tmp;
    }

    //endregion

    //region 206. Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode tmp = null;
        ListNode newHead = null;

        while (head != null) {

            newHead = new ListNode(head.val);
            newHead.next = tmp;

            head = head.next;

            tmp = newHead;

        }

        return newHead;
    }
    //endregion

    //region 217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {

        if (nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp == nums[i]) {
                return true;
            }
            tmp = nums[i];
        }

        return false;
    }
    //endregion

    //region 219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(nums[i])) {
                int tmp = i - hashMap.get(nums[i]);
                if (tmp <= k) {
                    return true;
                }
            }

            hashMap.put(nums[i], i);

        }

        return false;

    }
    //endregion

    //region 226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
    //endregion

    //region 228. Summary Ranges
    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            return list;
        }

        int current = nums[0];
        int next = nums[0];

        int s1 = current;

        for (int i = 0; i < nums.length; i++) {

            current = nums[i];
            if (i < nums.length-1) {
                next = nums[i+1];
            }

            if ((current+1) != next) {
                String s;
                if (s1 == current) {
                    s = Integer.toString(s1);
                } else {
                    s = Integer.toString(s1) + "->" + Integer.toString(current);
                }
                list.add(s);
                current = next;
                s1 = next;
            }

        }

        return list;

    }
    //endregion

    //region 231. Power of Two
    public boolean isPowerOfTwo(int n) {

        if (n<=0) {return false;}
        if (n==1) {return true;}

        if (n%2!=0) {
            return false;
        }

        while (n>2) {
            int tmp = n/2;
            if (tmp%2!=0) {
                return false;
            }
            n = tmp;
        }

        return true;

    }
    //endregion

    //region 234. Palindrome Linked List
    public boolean isPalindrome(ListNode head) {

        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    //endregion

    //region 235. Lowest Common Ancestor of a Binary Search Tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }

    //endregion

}

class MyStack {

    private ArrayDeque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the top element. */
    public int top() {
        return queue.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

