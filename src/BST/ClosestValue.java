package BST;

import BinaryTree.TreeNode;

public class ClosestValue {

    public static int findClosestValueInBst(TreeNode tree, int target) {
       int closestValue = tree.val;
       closestValueIterative(tree, closestValue, target);
       return closestValue;
    }

    public static int closestValueIterative(TreeNode tree, int closestValue, int target){
        if(Math.abs(target - closestValue) > Math.abs(target - tree.val)){
            closestValue = tree.val;
        }
        if(tree.left != null && target < tree.val){
            return closestValueIterative(tree.left, closestValue, target);
        } else if (tree.right != null && target > tree.val){
            return closestValueIterative(tree.right, closestValue, target);
        }else{
            return closestValue;
        }
    }




}
