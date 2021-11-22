package BinaryTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeHeightDFSBalancedLeetCode {
    /*
    Max depth of binary tree DFS
     */
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }


    public void dfs(TreeNode node, int level){
        if(node == null){
            max = Math.max(level -1, max);
            return;
        }
        dfs(node.left, level +1);
        dfs(node.right, level +1);
    }

    public static int height(TreeNode root){
        if(root == null)
            return -1;
        int leftHgt = height(root.left);
        int rightHgt = height(root.right);

        int rootHeight = 1 + Math.max(leftHgt, rightHgt);
        return rootHeight;
    }

    public boolean isBalanced(TreeNode root) {
        // boolean isBalanced = true;
        boolean[] ans = new boolean[1];
        ans[0] = true;
        height(root, ans);
        return ans[0];
    }

    public int height(TreeNode root, boolean[] isBalanced){
        if(root == null)
            return -1;
        int leftHgt = height(root.left, isBalanced);
        int rightHgt = height(root.right, isBalanced);
        int diff = Math.abs(leftHgt - rightHgt);
        if(diff>1) isBalanced[0] = false;
        int rootHeight = 1 + Math.max(leftHgt, rightHgt);
        return rootHeight;
    }

    public static void Main(String[] args)
    {
        TreeNode t= new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        // bt.root.left.left = new TreeNode(4);
        // bt.root.left.right = new TreeNode(5);
        //            bt.printPreOrderTree(bt.root);
        //            bt.printInOrderTree(bt.root);
        //            bt.printPostOrderTree(bt.root);
        int h = height(t);
    }

    public static class BinaryTreeIsSameLeetCode {
        /*
        TC: O(n)
        SC: O(n)
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right ,q.right);
        }
        /*
        TC: O(n)
        SC : O(n)
         */
        public boolean isSymmetric(TreeNode root) {
            return sym(root, root);
        }

        public boolean sym(TreeNode A, TreeNode B){
            if(A == null && B == null) return true;
            if(A == null || B == null) return false;
            if(A.val != B.val) return false;
            return sym(A.left, B.right) && sym(A.right, B.left);
        }
        /*
        TC: O(n)
        SC: O(n)/O(H)
         */
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return null;

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }

    public static class BinaryTreeTest {
        static BinaryTree bt;
            /*
                  1
                 /\
                2  3
               /\
              4  5
           (a) Inorder (Left, Root, Right) : 4 2 5 1 3
           (b) Preorder (Root, Left, Right) : 1 2 4 5 3
           (c) Postorder (Left, Right, Root) : 4 5 2 3 1
            */
            // O(n) space O(n)
           /* public List<Integer> inorderTraversal(LinkedListTest.BinaryTree.TreeNode root) {
                List<Integer> res = new ArrayList();
                Stack<LinkedListTest.BinaryTree.TreeNode> stack = new Stack<>();
                LinkedListTest.BinaryTree.TreeNode curr = root;
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
            }*/
            public static void Main(String[] args)
            {
                bt.root = new TreeNode(1);
                bt.root.left = new TreeNode(2);
                bt.root.right = new TreeNode(3);
               // bt.root.left.left = new TreeNode(4);
               // bt.root.left.right = new TreeNode(5);
    //            bt.printPreOrderTree(bt.root);
    //            bt.printInOrderTree(bt.root);
    //            bt.printPostOrderTree(bt.root);
                int h = height(bt.root);
            }
            /*
            TC: O(n)
            SC: O(H) H height of the tree
             */
            public static List<Integer> preOrderTree(TreeNode root){
                List<Integer> res = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                if(root == null) return res;
                stack.add(root);
                while(!stack.isEmpty()){
                    TreeNode temp = stack.pop();
                    res.add(temp.val);
                    if(temp.right != null) stack.add(temp.right);
                    if(temp.left != null) stack.add(temp.left);
                }
                return res;
            }
            /*
            TC: O(n)
            SC: O(H) H height of the tree
             */
            public static List<Integer> inOrderTree(TreeNode root){
                List<Integer> res = new ArrayList<>();
                Stack<TreeNode> stack = new Stack<>();
                if(root == null) return res;
                TreeNode node = root;
                while(!stack.isEmpty() || node !=null){
                    if(node != null){
                        stack.add(node);
                        node = node.left;
                    } else {
                        node = stack.pop();
                        res.add(node.val);
                        node = node.right;
                    }
                }
                return res;
            }

        public static List<Integer> postOrderTree(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            if (root == null) return res;
            stack1.add(root);
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                stack2.add(node);
                if(node.left !=null)stack1.add(node.left);
                if(node.right !=null)stack1.add(node.right);
            }
            while(!stack2.isEmpty()){
                res.add(stack2.pop().val);
            }
            return res;
        }
    }
}
