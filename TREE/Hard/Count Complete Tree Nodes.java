class Solution {
    public int countNodes(TreeNode root) {
        
        if(root==null)
            return 0;

        int leftCount = findLeftCount(root.left);
        int rightCount= findRightCount(root.right);

        if(leftCount==rightCount)
            return (int) Math.pow(2,rightCount+1)-1;

        return countNodes(root.left)+countNodes(root.right)+1;
    }

    private int findLeftCount(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    private int findRightCount(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }

        return count;
    }
}
