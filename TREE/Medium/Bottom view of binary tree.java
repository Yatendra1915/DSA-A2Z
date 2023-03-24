class Solution
{
    
    class Pair{
        
        int val;
        int level;
        
        Pair(int val,int level){
            this.val=val;
            this.level=level;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    
    int min =Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        
        ArrayList<Integer> arr =new ArrayList<>();
        Map<Integer,Pair> map = new HashMap<>();
        
        if(root==null) return arr;
        
        findBottomView(root,0,0,map);
        
        for(int i=min;i<=max;i++){
            arr.add(map.get(i).val);
        }
        
        return arr;
    }
    
    public void findBottomView(Node root,int col,int level,Map<Integer,Pair> map){
        
        if(root==null) return;
        
        min=Math.min(min,col);
        max=Math.max(max,col);
        
        if(!map.containsKey(col) || level>= map.get(col).level){
            map.put(col,new Pair(root.data,level));
        }
        
        findBottomView(root.left,col-1,level+1,map);
        findBottomView(root.right,col+1,level+1,map);
        
        return;
        
    }
}
