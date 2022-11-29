class Solution {
    
    List<List<Integer>> list;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        list = new ArrayList<>();
        helper(k,n,1,new ArrayList<>());
        return list;
    }
    
    private void helper(int k,int n,int num,List<Integer> temp){
        
        if(k==0){
            if(n==0){
                list.add(new ArrayList(temp));
            }
            return;
        }
        
        for(int i=num;i<=9;i++){
            temp.add(i);
            helper(k-1,n-i,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
