class Solution {

    int preindex=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        return constructTree(preorder,inorder,0,n-1);
    }

    private TreeNode constructTree(int[] preorder,int[] inorder,int low,int high){

        if(low>high){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preindex++]);

        int i=0;

        for(i=low;i<=high;i++){
            if(node.val==inorder[i]){
                break;
            }
        }

        node.left =constructTree(preorder,inorder,low,i-1);
        node.right=constructTree(preorder,inorder,i+1,high);

        return node;

    }
}
