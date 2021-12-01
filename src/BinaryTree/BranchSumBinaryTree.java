package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSumBinaryTree {
    public static List<Integer> branchSums(TreeNode root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<>();
        return branchSums(root, 0, sums);
    }

    public static List<Integer> branchSums(TreeNode root, int sum, List<Integer> sums) {
        if(root == null)
            return sums;
        sum = sum + root.val;
        if(root.right == null && root.left == null){
            sums.add(sum);
        }
        if(root.left !=null){
            branchSums(root.left, sum, sums);
        }
        if(root.right !=null){
            branchSums(root.right, sum, sums);
        }
        return sums;
    }
}
