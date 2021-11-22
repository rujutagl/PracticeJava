package BinaryTree;


public class BinaryTree {
    TreeNode root;

    void printPostOrderTree(TreeNode node) {
        if (node == null) return;
        printPostOrderTree(node.left);
        printPostOrderTree(node.right);
        System.out.println(node.val + " ");
    }

    void printPreOrderTree(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val + " ");
        printPreOrderTree(node.left);
        printPreOrderTree(node.right);
    }

    void printInOrderTree(TreeNode node) {
        if (node == null) return;
        printInOrderTree(node.left);
        System.out.println(node.val + " ");
        printInOrderTree(node.right);
    }
}
