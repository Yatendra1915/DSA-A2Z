class Solution {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        maxDepth(root);

        return isBalanced;
    }

    public int maxDepth(TreeNode root){

        if(root==null)
            return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight= maxDepth(root.right);

        if(Math.abs(leftHeight-rightHeight)>1)
            isBalanced=false;
        
        return Math.max(leftHeight,rightHeight)+1;

    }
}
