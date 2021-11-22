package BinaryTree;

public class ConstructBSTGivenInOrderPreOrderTree {
    /*
    TC: O(n)
    SC: O(1) not considering recursion or O(H)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
        Inorder - L Root Right
        PreOrder - Root L Right
        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]
        1. Preorder first element is root
        2. Search for index of root element in inorder, with that everything before root in inorder will be left inorder and
        everything on right wil be right inorder. So
        leftInorderStartIndex = start index of inorder list
        leftInOrderEndIndex = rootIndex -1
        rightInorderStartIndex = rootIndex+1
        rightInorderEndIndex = inorderEndIndex
        leftPreOrderStartIndex = start index of preorder +1
        leftPreOrderEndIndex  = leftInOrderEndIndex - leftInorderStartIndex + leftPreOrderStartIndex
        rightPreOrderStartIndex =leftPreOrderEndIndex+1
        rightPreOrderEndIndex = pre order end index
        3. First you need to calculate tree length.
        4. The recursively call createTree function and pass correct inorder and preorder list.
         */
        int n = preorder.length;
        return createTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode createTree(int[] preorder, int[] inorder, int preOrderStartIdx, int preOrderEndIdx, int inOrderStartIdx, int inOrderEndIdx){
        if(inOrderStartIdx > inOrderEndIdx) return null;
        int rootData = preorder[preOrderStartIdx];
        int rootIndex = -1;
        for(int i = inOrderStartIdx; i<= inOrderEndIdx ; i++){
            if(inorder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        int leftInOrderStartIndex = inOrderStartIdx;
        int leftInOrderEndIndex = rootIndex - 1;
        int rightInOrderStartIndex = rootIndex + 1;
        int rightInOrderEndIndex = inOrderEndIdx;
        int leftPreOrderStartIndex = preOrderStartIdx + 1;
        // leftPreOrderEndIndex - leftPreOrderStartIndex = leftInOrderEndIndex - leftInorderStartIndex
        int leftPreOrderEndIndex  = leftInOrderEndIndex - leftInOrderStartIndex + leftPreOrderStartIndex;
        int rightPreOrderStartIndex =leftPreOrderEndIndex + 1;
        int rightPreOrderEndIndex = preOrderEndIdx;

        TreeNode root = new TreeNode(rootData);
        root.left = createTree(preorder,inorder, leftPreOrderStartIndex,leftPreOrderEndIndex, leftInOrderStartIndex, leftInOrderEndIndex );
        root.right = createTree(preorder,inorder, rightPreOrderStartIndex,rightPreOrderEndIndex, rightInOrderStartIndex, rightInOrderEndIndex );
        return root;
    }
}
