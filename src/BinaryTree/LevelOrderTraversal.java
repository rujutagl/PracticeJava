package BinaryTree;

import java.util.*;

public class LevelOrderTraversal {

    /*
    TC: O(n)
    SC: O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            int n = q.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < n ; i++){
                TreeNode temp = q.poll();
                tempList.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            res.add(tempList);
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> tempList = new ArrayList<>();
        if(root== null) return tempList;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            int n = q.size();
            for(int i = 0; i < n ; i++){
                TreeNode temp = q.poll();
                if(i == n-1)
                    tempList.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }

        }
        return tempList;
    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> tempList = new ArrayList<>();
        if(root== null) return tempList;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size() > 0) {
            int n = q.size();
            for(int i = 0; i < n ; i++){
                TreeNode temp = q.poll();
                if(i == 0)
                    tempList.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }

        }
        return tempList;
    }
    /*
    TC : O(n)
    SC: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        if(root == null)return res;
        q.add(root);
        int l = 0;
        while(q.size() > 0){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i< n ;i++){
                TreeNode node = q.poll();
                if(l%2 == 0){
                    level.add(node.val);
                }else{
                    stack.add(node.val);
                }
                 if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            l++;
            while(!stack.isEmpty()){
                level.add(stack.pop());
            }
            res.add(level);
        }
        return res;
    }

}
