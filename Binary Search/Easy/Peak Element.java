class Solution {
    public int findPeakElement(int[] nums) {
       
        int n = nums.length;
        
        // Base Case 1 
      
        // if n==1 return 0 index because it is the peak
        if(n==1)
            return 0;
        // Base Case 2
        if(nums[0]>nums[1])
            return 0;
    
        // Base Case 3
        if(nums[n-1]>nums[n-2])
            return n-1;
        
        int low=0,high=n-1;
        
        while(low<high){
        
            int mid=(low+high)/2;
            
            // if mid idx ele is greater than its neighbour then return mid idx;
            if((nums[mid]>nums[mid+1])&&(nums[mid]>nums[mid-1]))
                return mid;
          
            // if our nums[mid]<nums[mid+1] then we are sure that our peak will lie on right side and take low = mid+1;
            else if(nums[mid]<nums[mid+1])
                low=mid+1;
          
            // if nums[mid]>nums[mid+1] then either our mid or index less than mid could be peak index so take high = mid;
            else
                high = mid;
        }
        
        // low==high doesn't matter return either it'll be peak element idx for sure
        return low;
    }
}
