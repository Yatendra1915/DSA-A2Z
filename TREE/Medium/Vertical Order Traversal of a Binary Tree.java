class Solution {

    class Node{
        int val;
        int row;

        Node(int val,int row){
            this.val=val;
            this.row=row;
        }
    }

    List<List<Integer>> list;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        list = new ArrayList<>();

        dfs(root,0,0,0);
        return sorted();
    }

    Map<Integer,List<Node>> map = new HashMap<>();

    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;

    public void dfs(TreeNode root,int row,int col){

        if(root==null){
            return;
        }

        max=Math.max(max,col);
        min=Math.min(min,col);

        List<Node> tempList = map.getOrDefault(col,new ArrayList<>());
        tempList.add(new Node(root.val,row));

        map.put(col,tempList);

        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);

    }

    public List<List<Integer>> sorted(){

        List<List<Integer>> res = new ArrayList<>();

        for(int i=min;i<=max;i++){

            List<Node> temp = map.get(i);

            Collections.sort(temp,new Comparator<Node>(){
                
                public int compare(Node a,Node b){
                   
                    return (a.row==b.row)?a.val-b.val:a.row-b.row;
                }
            });


            
            List<Integer> verticalSortedCol = new ArrayList<>();

            for(Node node:temp){
                verticalSortedCol.add(node.val);
            }
            res.add(verticalSortedCol) ;
            
        }

        return res;
    }

    
}
