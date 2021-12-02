package LinkedList;

import java.util.*;

class ListNode {
    int data;
    ListNode next;
    ListNode(int tmp) {
        data= tmp;
    }
}

class BinaryTree1 {
    Node root;
    BinaryTree1(){};
    BinaryTree1(Node root){
        this.root = root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class LinkedListTest {
    static ListNode head1, head2;
    static BinaryTree1 bt = new BinaryTree1();

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        head1 = a1;
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        head2 = b1;
        b1.next = b2;
        b2.next = b3;
//        LinkedList.ListNode result = addTwoNumbers(head1, head2);
//        printList(result);

        // odd even list 1,9,1,2,4
        ListNode1 a11 = new ListNode1(1);
        ListNode1 a21 = new ListNode1(9);
        ListNode1 a31 = new ListNode1(1);
        ListNode1 a41 = new ListNode1(2);
        ListNode1 a51 = new ListNode1(4);
        a11.next = a21;
        a21.next = a31;
        a31.next = a41;
        a41.next = a51;
        a51.next = null;
        // ListNode1 result = oddEvenList(a11);
        //3,2,4
        ListNode1 a12 = new ListNode1(3);
        ListNode1 a22 = new ListNode1(2);
        ListNode1 a32 = new ListNode1(4);
        a12.next = a22;
        a22.next = a32;
        a32.next = null;
       // ListNode1 result1 = getIntersectionNode(a11, a12);
        //printList1(result1);
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        //bt.printPreOrderTree(bt.root);
        //bt.printInOrderTree(bt.root);
        //bt.printPostOrderTree(bt.root);
       // System.out.println(inorderTraversal(bt.root));

        // next right pointers use queue
        BinaryTree1 tree = new BinaryTree1();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
       // System.out.println(connect(tree.root));
        BinaryTree1 tree1 = new BinaryTree1();
        tree1.root = new Node(3);
        tree1.root.left = new Node(1);
        tree1.root.right = new Node(4);
        tree1.root.left.right = new Node(2);
        //int i = kthSmallestBST(tree1.root, 1);

        // reverse a linked list
        ListNode1 reversedList = reversedList(a11);
    }

    public static void printList(ListNode l) {
        while (l != null) {
            System.out.println(l.data);
            l = l.next;
        }

        System.out.println();
    }

    public static void printList1(ListNode1 l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode tmp = null;
        ListNode prev = null;
        while (l1 != null || l2 != null) {
            int sum = carry + (l1 == null ? 0 : l1.data) + (l2 == null ? 0 : l2.data);
            carry = sum / 10;
            sum = sum % 10;
            tmp = new ListNode(sum);
            if (result == null) {
                result = tmp;
            } else {
                prev.next = tmp;
            }
            prev = tmp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            tmp.next = new ListNode(carry);
        }
        return result;
    }

    // Odd Even Linked List O(n) space O(1)
    public static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1() {
        }

        ListNode1(int val) {
            this.val = val;
        }

        ListNode1(int val, ListNode1 next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode1 oddEvenList(ListNode1 head) {
        if (head == null) return null;
        ListNode1 odd = head, evenHead = head.next, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // Intersection of Two Linked Lists
    public static ListNode1 getIntersectionNode(ListNode1 headA, ListNode1 headB) {
        // Find the length of two lists
        int lenA = 0;
        ListNode1 tempA = headA;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        int lenB = 0;
        ListNode1 tempB = headB;
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }

        // find the diff to decide how many node to skip from larger list
        int diff = Math.abs(lenA - lenB);
        // iterate over the larger list for diff nodes
        tempA = headA;
        tempB = headB;
        if (lenA > lenB) {
            while (diff-- > 0) {
                tempA = tempA.next;
            }
        } else {
            while (diff-- > 0)
                tempB = tempB.next;
        }

        // check until we find intersection node
        while (tempB != tempA) {
            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == null || tempB == null)
                return null;
        }
        return tempA;
    }
    // O(n) space O(n)
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // O(n) space O(1)
    //Populating Next Right Pointers in Each LinkedList.Node
    public static Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr == null && q.isEmpty()){
                return root;
            } else if(curr == null){
                q.add(null);
                continue;
            } else {
                curr.next = q.peek();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return root;
    }

    // kth smallest element in BST
    public static int kthSmallestBST(Node root, int k) {
        int smallest = 0;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            smallest = smallest+1;
            if(smallest == k){
                return  curr.val;
            }
            curr = curr.right;
        }
        return curr.val;
    }
    // 1 9 1 2 4 -> 4 2 1 9 1
    public static ListNode1 reversedList(ListNode1 head) {
        /*ListNode1 prev = null;
        ListNode1 temp = null;
        while (head != null){
            temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;*/
        // using stack if its immutable linked list
        Stack<Integer> st = new Stack<>();
        while(head != null){
            st.push(head.val);
            head = head.next;
        }
        while(!st.empty()){
            int top = st.peek();
            System.out.println(top);
            st.pop();
        }
        return head;
    }
}
