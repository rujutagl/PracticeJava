package BinaryTree;

public class NodeStrVal {
        //int val;
        String val;
    NodeStrVal left;
    NodeStrVal right;
    NodeStrVal() {}
        //BinaryTree.TreeNode(int val) { this.val = val; }
    /*BinaryTree.TreeNode(int val, BinaryTree.TreeNode left, BinaryTree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }*/
        NodeStrVal(String val) { this.val = val; }
    NodeStrVal(String val, NodeStrVal left, NodeStrVal right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

}
