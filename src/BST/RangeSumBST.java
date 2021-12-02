package BST;

import BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {
    // TC & SC: O(n)
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) return sum;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr.val >= low && curr.val <=high){
                sum = sum+ curr.val;
            }
            if(curr.left != null && curr.val > low){
                queue.add(curr.left);
            }
            if(curr.right != null && curr.val < high){
                queue.add(curr.right);
            }
        }
        return sum;
    }
}
