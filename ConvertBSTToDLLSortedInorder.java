package BST;

import BinaryTree.TreeNode;

public class ConvertBSTToDLLSortedInorder {

    static void convert(TreeNode root){

        convert(root, null);
    }

    static void convert(TreeNode root, TreeNode head){
        if(root == null) return;
        TreeNode prev = new TreeNode();
        convert(root.left, head);
        if(prev==null){
            head = root;
        } else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right, head);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(12);
        TreeNode leftLeft = new TreeNode(25);
        TreeNode leftRight = new TreeNode(30);
        left.left = leftLeft;
        left.right = leftRight;
        root.left = left;
        TreeNode right = new TreeNode(15);
        TreeNode rightLeft = new TreeNode(36);
        right.left = rightLeft;
        root.right = right;
        convert(root);
    }
}
