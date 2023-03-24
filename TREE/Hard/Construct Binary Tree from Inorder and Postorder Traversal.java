class Solution {
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;

        postindex=n-1;

        return constructTree(inorder,postorder,0,n-1);
    }

    private TreeNode constructTree(int[] inorder,int[] postorder,int low,int high){

        if(low>high) return null;

        TreeNode root = new TreeNode(postorder[postindex--]);

        int i=0;

        for(i=low;i<=high;i++){
            if(root.val==inorder[i]){
                break;
            }
        }

        root.right= constructTree(inorder,postorder,i+1,high);
        root.left = constructTree(inorder,postorder,low,i-1);

        return root;
    }
}
