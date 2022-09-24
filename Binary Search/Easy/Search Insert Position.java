class Solution {
    public int searchInsert(int[] nums, int target) {
        
        // our index could lie between 0 to length of array so take high and low as :-
        int low=0,high=nums.length;
        
        // take low<high to avoid array index out of bound 
        /*
          we are using little bit modified binary search which will also work for duplicate elemnts 
          and will always give first index on case of duplicats where we acn insert element
        */
        while(low<high){
            
            int mid=(high-low)/2 + low;
            
            // if nums[mid]<target then take left segment and low = mid+1;
            if(nums[mid]<target)
                low=mid+1;
          
            // if nums[mid]>=target then take high = mid because mid index could also be required index
            else
                high=mid;
            
        }
        
        return low;
        
    }    
}
