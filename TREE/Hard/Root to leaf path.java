class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        findRootToLeaves(root,arr,new ArrayList<>());
        
        return arr;
        
    }
    
    public void findRootToLeaves(Node root,ArrayList<ArrayList<Integer>> arr,ArrayList<Integer> temp){
        
        if(root==null)
            return;
            
        if(root.left==null && root.right == null){
            temp.add(root.data);
            arr.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        temp.add(root.data);
        
        findRootToLeaves(root.left,arr,temp);
        findRootToLeaves(root.right,arr,temp);
        
        temp.remove(temp.size()-1);
        
        return;
    }
    
}
