class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        
        return checkChildrenSumProperty(root)==true?1:0;
    }
    
    public static boolean checkChildrenSumProperty(Node root){
        if(root==null ||( root.right==null && root.left==null))
            return true;
            
        int child=0;
        
        if(root.left!=null) child+=root.left.data;
        if(root.right!=null) child+=root.right.data;
        
        return (child==root.data) && checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right);
    }
}
