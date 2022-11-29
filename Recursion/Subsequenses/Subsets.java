class Solution {
    
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        
        list = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return list;
    }
    
    public void helper(int[] nums,int idx,List<Integer> temp){
        
        if(idx==nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        
        helper(nums,idx+1,temp);
        
        temp.add(nums[idx]);
        helper(nums,idx+1,temp);
        temp.remove(temp.size()-1);
        
        return;
    }
}
