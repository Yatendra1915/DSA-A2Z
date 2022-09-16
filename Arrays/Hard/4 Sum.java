class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                
                int low=j+1,high=n-1,value=target-nums[i]-nums[j];
                
                while(low<high){
                    
                    if(nums[low]+nums[high]>value)
                        high--;
                    else if(nums[low]+nums[high]<value)
                        low++;
                    else{
                        
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        list.add(temp);
                        
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        
                        low++;
                        high--;
                    }
                }
                
                while(j<n-2 && nums[j]==nums[j+1]) j++;
                
            }
            
            while(i<n-3 && nums[i]==nums[i+1]) i++;
        }
        
        
        return list;
        
    }
}
