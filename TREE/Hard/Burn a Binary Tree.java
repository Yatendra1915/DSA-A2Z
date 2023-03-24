class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    static Node targetNode;
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        if(root==null) return 0;
        targetNode=null;
        Map<Node,Node> map = new HashMap<>();
        
        findParent(root,map,target);
        
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        
        Set<Node> visited = new HashSet<>();
        int steps = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            steps++;
            while(size-->0){
                
                Node temp =q.poll();
                
                visited.add(temp);
                
                if(temp.left!=null && !visited.contains(temp.left)){
                    q.add(temp.left);
                }
                
                if(temp.right!=null && !visited.contains(temp.right)){
                    q.add(temp.right);
                }
                
                if(map.containsKey(temp) && !visited.contains(map.get(temp))){
                    q.add(map.get(temp));
                }
                
            }
        }
        
        return steps-1;
    }
    
    
    
    
    
    private static void findParent(Node root,Map<Node,Node> map,int target){
        
        
        if(root==null)
            return ;
        
        if(root.data==target){
            targetNode=root;
        }
        if(root.left!=null){
            map.put(root.left,root);
        }
        
        if(root.right!=null){
            map.put(root.right,root);
        }
        
        findParent(root.left,map,target);
        findParent(root.right,map,target);
    }
}
