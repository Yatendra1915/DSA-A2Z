class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        
        int first = leftSearch(nums,target,n);
        int last  = rightSearch(nums,target,n);
        
        return new int[]{first,last};
    }
    
    public int leftSearch(int nums[],int target,int n){
        
        int low =0;
        int high = n-1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(mid>0 && nums[mid]==target && nums[mid-1]!=nums[mid] || nums[mid]==target && mid==0)
                return mid;
            
            else if(nums[mid]>=target)
                high = mid-1;
            
            else if(nums[mid]<target)
                low = mid+1;
        }
        
        return -1;
    }
    
    public int rightSearch(int[] nums,int target,int n){
                
        int low =0;
        int high = n-1;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(mid<high && nums[mid]==target && nums[mid]!=nums[mid+1] || nums[mid]==target && mid==high)
                return mid;
            
            else if(nums[mid]>target)
                high = mid-1;
            
            else if(nums[mid]<=target)
                low = mid+1;
        }
        
        return -1;
    }
        
                                                        
}
