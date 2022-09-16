class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i=0;i<n-2;i++){
            
            //if(i==0 || i>0 && nums[i]!=nums[i-1]){
            
                int low = i+1;
                int high= n-1;
            
                int sum = -nums[i];
            
                while(low<high){
                
                    if(nums[low]+nums[high]>sum){
                        high--;
                    }
                    else if(nums[low]+nums[high]<sum){
                        low++;
                    }
                
                    else{
                    
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        list.add(temp);
                        
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                
                }
            //}
            
            while(i<n-2 &&  nums[i]==nums[i+1]) i++;
        }
        
        return list;
    }
}
