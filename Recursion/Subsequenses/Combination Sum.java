class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> list =new ArrayList<>();
       
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>(),list);
        
        for(List<Integer> ls:set){
            list.add(ls);
        }
        
        return list;
    }
    
    public void helper(int[] candidates,int target,int i,List<Integer> temp,List<List<Integer>> list){
        
        if(target==0){
            set.add(new ArrayList(temp));
            return;
        }
        
        if(i>=candidates.length)
            return ;
    
        
        if(target-candidates[i]>=0){
            temp.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,temp,list);
            temp.remove(temp.size()-1);
        }
        
        while(i+1 < candidates.length && candidates[i]==candidates[i+1]) {
           i++;     
       }
        
        helper(candidates,target,i+1,temp,list);
    }
}
