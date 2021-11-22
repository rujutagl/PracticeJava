package BinaryTree;

public class DiameterOfBinaryTreeLeetCode {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    public int height(TreeNode root, int[] ans){
        if(root == null) return -1;

        int leftHeight = height(root.left, ans);
        int rightHeight = height(root.right, ans);

        int h = 1+Math.max(leftHeight, rightHeight);

        int d = leftHeight + rightHeight + 2;
        ans[0] = Math.max(d, ans[0]);

        return h;
    }
}
