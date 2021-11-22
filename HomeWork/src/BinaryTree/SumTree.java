package BinaryTree;

public class SumTree {
    // O(n2)
    public boolean isSumTree(TreeNode root){
        int leftSum, rightSum = 0;
        if(root == null || (root.left ==null && root.right == null)){
            return true;
        }
        leftSum = sum(root.left);
        rightSum = sum(root.right);
        if((root.val == leftSum+rightSum) && isSumTree(root.left) && isSumTree(root.right))
            return true;
        return false;
    }

    public int sum(TreeNode root){
        if(root ==null) return 0;
        return sum(root.left)+root.val+ sum(root.right);
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = maxDepth2(root);
        findSum(root, 1, maxDepth);
        return sum;
    }
    public void findSum(TreeNode root, int curr, int maxDepth){
        if(root !=null){
            if(curr == maxDepth){
                sum = sum+root.val;
            }
            findSum(root.left, curr+1, maxDepth);
            findSum(root.right, curr+1, maxDepth);
        }

    }
}
