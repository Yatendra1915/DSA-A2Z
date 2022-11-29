class Solution {
    
    List<List<Integer>> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        list = new ArrayList<>();
        
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>());
        return list;
    }
    
    private void helper(int[] nums,int idx,List<Integer> temp){
        
        
        if(idx == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        
        temp.add(nums[idx]);
        helper(nums,idx+1,temp);
        temp.remove(temp.size()-1);
        
        while(idx+1<nums.length && nums[idx]==nums[idx+1]) idx++;
        
        helper(nums,idx+1,temp);
    }
}
