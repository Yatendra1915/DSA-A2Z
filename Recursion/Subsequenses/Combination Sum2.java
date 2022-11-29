class Solution {
    
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        list=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>());
        
        return list;
    }
    
    public void helper(int[] candidates,int target,int i,List<Integer> temp){
        
        if(target==0){
            list.add(new ArrayList(temp));
            return;
        }
        
        if(i>=candidates.length)
            return ;
    
        
        if(target-candidates[i]>=0){
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,temp);
            temp.remove(temp.size()-1);
        }
        
        while(i+1 < candidates.length && candidates[i]==candidates[i+1]) {
           i++;     
       }
        
        helper(candidates,target,i+1,temp);
    }
}
