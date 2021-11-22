package BinaryTree;

import java.util.*;

public class VerticalTraversalBST {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> tmap= new TreeMap();
        if(root == null) return res;
        levelOrderTraversal(root, 0, tmap);
        res.addAll(tmap.values());
        return res;
    }
    public void levelOrderTraversal(TreeNode root, int idx, TreeMap<Integer, List<Integer>> tmap) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> lines = new LinkedList<>();
        q.add(root);
        lines.add(0);
        while(q.size()>0){
            TreeNode temp = q.poll();
            int i = lines.poll();
            if(!tmap.containsKey(i))tmap.put(i, new ArrayList<>());
            tmap.get(i).add(temp.val);
            /*
            for top view we just need add element if its not present in treemap. as we need only top view
             if(!tmap.containsKey(i))tmap.put(i, temp.val);
             for bottom view keep inserting in tmap so it will keep overwriting it and we will eventually get last element
             tmap.put(i,temp.val)
             */
            if(temp.left!=null){
                q.add(temp.left);
                lines.add(i-1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                lines.add(i+1);
            }
        }
    }

    static ArrayList <Integer> verticalOrder(TreeNode root)
    {
        // add your code here
        ArrayList <Integer> res = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        if(root == null) return res;
        verticleOrderTriversal(map, root);
        for(ArrayList <Integer> arr:map.values()){
            res.addAll(arr);
        }
        return res;
    }

    public static void verticleOrderTriversal(TreeMap<Integer, ArrayList<Integer>> map, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> lines = new LinkedList<>();
        q.add(root);
        lines.add(0);
        while(q.size()>0){
            TreeNode temp = q.poll();
            int i = lines.poll();
            if(!map.containsKey(i))map.put(i, new ArrayList<>());
            map.get(i).add(temp.val);
            if(temp.left!=null){
                q.add(temp.left);
                lines.add(i-1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                lines.add(i+1);
            }
        }

    }
}
