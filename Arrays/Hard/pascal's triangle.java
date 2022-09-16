class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new LinkedList<>();
        
        List<Integer> prev = new LinkedList<>();
        prev.add(1);
        res.add(prev);
        for(int j=1;j<numRows;j++){
            List<Integer> curr = new LinkedList<>();
            
            curr.add(1);
            for(int i=1;i<prev.size();i++){
                curr.add(prev.get(i-1)+prev.get(i));
            }
            
            curr.add(1);
            prev=curr;
            res.add(curr);
        }
        
        return res;
    }
}
