class Pair{
    Node node;
    int col;
    
    Pair(Node node,int col){
        this.node=node;
        this.col=col;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            
            
            Pair temp = queue.poll();
            
            max=Math.max(max,temp.col);
            min=Math.min(min,temp.col);
            
            if(!map.containsKey(temp.col)){
                map.put(temp.col,temp.node.data);
            }
            
            if(temp.node.left!=null){
                queue.add(new Pair(temp.node.left,temp.col-1));
            }
            
            if(temp.node.right!=null){
                queue.add(new Pair(temp.node.right,temp.col+1));
            }
            
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=min;i<=max;i++){
            arr.add(map.get(i));
        }
        
        return arr;
        
        
    }
}
