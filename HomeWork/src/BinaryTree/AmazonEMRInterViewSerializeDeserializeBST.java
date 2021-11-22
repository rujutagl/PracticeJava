package BinaryTree;/*> 	1	  2+2		5+2*3
        >
        >	1	   +         +              *
        >		  /	\       / \
        > 		 2	 2     5   *
        >			          / \
        >			         2   3

        0-9
        * / + -

        > 	2+5*3 is 17 without parens or 21 with parens. We want to preserve the values of the subtrees
        >
        > ```
        >	   (2+5)*3=21	   	 2*5+3=13		(6-5+3)*9 	      ((1+2)*3-4)*5
        >     		*     			+				*					*
        >    	   / \    	   	   / \			   / \				   / \
        >   	  +   3   	  	  *   3			  +   9				  -   5
        >  		 / \     		 / \   			 / \                 / \
        > 		2   5 			2   5			-   3               *   4
        >									   / \                 / \
        > 									  6   5               +   3
        >														 / \
        >														1	2
        > ```*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonEMRInterViewSerializeDeserializeBST {
    public static String evaluateTree(NodeStrVal root, StringBuilder sb){
        // validate
        if(root.val == "+")
            return evaluateTree(root.left , sb) + "+"+ evaluateTree(root.left , sb);
        return sb.toString();
    }

    public static int evalTree1(NodeStrVal root)
    {

        // Empty tree
        if (root == null)
            return 0;


        // Evaluate left subtree
        int leftEval = evalTree1(root.left);

        // Evaluate right subtree
        int rightEval = evalTree1(root.right);

        // Check which operator to apply
        if (root.val.equals("+"))
            return leftEval + rightEval;

        if (root.val.equals("-"))
            return leftEval - rightEval;

        if (root.val.equals("*"))
            return leftEval * rightEval;

        return leftEval / rightEval;
    }


    public static void main(String[] args) {
        NodeStrVal root = new NodeStrVal();
        NodeStrVal left = new NodeStrVal();
        left.val = "2";
        NodeStrVal right = new NodeStrVal();
        right.val = "2";
        root.val = "+";
        root.left = left;
        root.right= right;
        StringBuilder sb = new StringBuilder();
        evaluateTree(root,sb);
        //evalTree1(root);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();

    }

    public void preOrder(TreeNode root, StringBuilder sb ){
        if(root == null) {
            sb.append("null,");
        }else {
            sb.append(root.val+",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitArr = data.split(",");
        List<String> list = new ArrayList(Arrays.asList(splitArr));
        return preOrder(list);
    }

    public TreeNode preOrder(List<String> list){
        String s = list.get(0);
        if(s.equals("null")) {
            list.remove(0);
            return null;
        } else{
            int num = Integer.parseInt(s);
            TreeNode root = new TreeNode();
            list.remove(0);
            root.val = num;
            root.left = preOrder(list);
            root.right = preOrder(list);
            return root;
        }
    }
}
