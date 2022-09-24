class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        
        int low = 0;
        int high = n-1;
        
        while(low<high){
            
            int mid = (low+high)/2;
            
            // means mid lies at right side and nums[mid] coudn't be our min for sure beacuse it is greater than high
            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            // means our mid or elemnts on left side of mid could contain min element
            else if(nums[mid]<nums[high]){
                high = mid;
            }
        
        }
        
        // low==high so return either
        return nums[high];
    }
}
