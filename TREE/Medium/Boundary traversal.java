class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    
	    if(node==null)
	        return res;
	   res.add(node.data);
	   
	   findLeftBoundary(node.left,res);
	   findLeaves(node.left,res);
	   findLeaves(node.right,res);
	   
	   ArrayList<Integer> rightLeaves = new ArrayList<>();
	   findRightBoundary(node.right,rightLeaves);
	   
	   for(int i=rightLeaves.size()-1;i>=0;i--){
	       res.add(rightLeaves.get(i));
	   }
	   
	   
	   
	   
	   return res;
	}
	
	private void findLeaves(Node node,ArrayList<Integer> res){
	    
	    if(node==null)
	        return;
	        
	    if(node.left==null && node.right==null){
	        res.add(node.data);
	        return;
	    }
	    
	    findLeaves(node.left,res);
	    findLeaves(node.right,res);
	    
	    return;
	    
	}
	
	private void findRightBoundary(Node node,ArrayList<Integer> res){
	    if(node==null)
	        return;
	        
	   if(node.left==null && node.right==null)
	        return;
	        
	   res.add(node.data);
	   
	   if(node.right!=null){
	       findRightBoundary(node.right,res);
	   }
	   else{
	       findRightBoundary(node.left,res);
	   }
	}
	
	private void findLeftBoundary(Node node,ArrayList<Integer> res){
	    
	   if(node==null)
	        return;
	        
	   if(node.left==null && node.right==null)
	        return;
	        
	   res.add(node.data);
	   
	   if(node.left!=null){
	       findLeftBoundary(node.left,res);
	   }
	   else{
	       findLeftBoundary(node.right,res);
	   }
	    
	}
}
