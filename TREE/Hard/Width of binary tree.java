class Pair{
    TreeNode node;
    int position;
    
    Pair(TreeNode node, int position){
        this.node=node;
        this.position = position;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));
        
        int width=1;
        while(!q.isEmpty()){
            
            int extremeLeftPos=0;
            int extremeRightPos=0;
            
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                Pair temp = q.poll();
                
                if(i==0){
                    extremeLeftPos=temp.position;
                }
                if(i==size-1){
                    extremeRightPos=temp.position;
                }
                
                if(temp.node.left!=null){
                    q.add(new Pair(temp.node.left,2*temp.position+1));
                }
                if(temp.node.right!=null){
                    q.add(new Pair(temp.node.right,2*temp.position+2));
                }
            }
            
            width=Math.max(width,extremeRightPos-extremeLeftPos+1);
        }
        return width;
    }
}
