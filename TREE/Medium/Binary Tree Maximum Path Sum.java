class Solution {

    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
        if(root==null) return 0;

        findMaxSum(root);

        return maxSum;
    }

    private int findMaxSum(TreeNode root){

        if(root==null)
            return 0;

        int leftSum = Math.max(0,findMaxSum(root.left));
        int rightSum=Math.max(0,findMaxSum(root.right));

        maxSum=Math.max(maxSum,leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum)+root.val;

    }
}
