class Solution {

    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null)
            return 0;

        findDiameter(root);

        return diameter;
    }

    public int findDiameter(TreeNode root){

        if(root==null)
            return 0;

        int left = findDiameter(root.left);
        int right=findDiameter(root.right);

        diameter = Math.max(diameter,left+right);

        return Math.max(left,right)+1;

    }

}
