package BinaryTree;

public class ConstructBSTGivenInOrderPostOrderTree {
    /*
    TC :O(n)
    SC: O(1) || O(H+N)
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    /*
    InOrder - L root Right
    PostOrder - L Right Root
    1. As post order is left/right/root that means whatever is the last element in postorder list is root element.
    2. Once you get the root we can check in inorder list for root index.
    3. Once you get the rootIndex whatever is on left side of that is basically left inorder list and whatever is right is right inorder list
    4. We can recursively call this function.
       leftInOrderStartIdx = inOrderStartIdx
       leftInOrderEndIdx = rootIdx - 1
       rightInOrderStartIdx = rootIdx + 1
       rightInOrderEndIdx = inOrderEndIdx
       leftPostOrderStartIdx = postOrderStartIdx
       // leftPostOrderEndIdx - leftPostOrderStartIdx = leftInOrderEndIdx - leftInOrderStartIdx
       leftPostOrderEndIdx =leftInOrderEndIdx - leftInOrderStartIdx + leftPostOrderStartIdx
       rightPostOrderStartIdx = leftPostOrderEndIdx +1;
       rightPostOrderEndIdx = postOrderEndIdx - 1
    5. Once you get all this, add root node which is basically inorder[rootIdx]
    6. Then recursively set left and right node to above idx
     */
        int n = inorder.length;
        return createTree(inorder, postorder, 0, n-1, 0 , n-1);
    }

    TreeNode createTree(int[] inorder, int[] postorder, int inOrderStartIdx, int inOrderEndIdx, int  postOrderStartIdx, int postOrderEndIdx){
        if(inOrderStartIdx > inOrderEndIdx) return null;
        int rootVal = postorder[postOrderEndIdx];
        int rootIdx = -1;
        for(int i = inOrderStartIdx; i<=inOrderEndIdx ; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        int leftInOrderStartIdx = inOrderStartIdx;
        int leftInOrderEndIdx = rootIdx - 1;
        int rightInOrderStartIdx = rootIdx + 1;
        int rightInOrderEndIdx = inOrderEndIdx;
        int leftPostOrderStartIdx = postOrderStartIdx;
        // leftPostOrderEndIdx - leftPostOrderStartIdx = leftInOrderEndIdx - leftInOrderStartIdx
        int leftPostOrderEndIdx =leftInOrderEndIdx - leftInOrderStartIdx + leftPostOrderStartIdx;
        int rightPostOrderStartIdx = leftPostOrderEndIdx +1;
        int rightPostOrderEndIdx = postOrderEndIdx - 1;
        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(inorder, postorder, leftInOrderStartIdx, leftInOrderEndIdx, leftPostOrderStartIdx, leftPostOrderEndIdx);
        root.right = createTree(inorder, postorder, rightInOrderStartIdx, rightInOrderEndIdx, rightPostOrderStartIdx, rightPostOrderEndIdx);
        return root;
    }
}
