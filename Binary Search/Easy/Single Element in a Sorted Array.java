class Solution {

    /*
      Example 1:

      Input: nums = [1,1,2,3,3,4,4,8,8]
      Output: 2
      Example 2:

      Input: nums = [3,3,7,7,10,11,11]
      Output: 10
    */
  
    /*
        bruteforce is to take xor of all elemnts
    */
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        
        int low = 0;
        int high= n-1;
        
        while(low<high){
            
            int mid = (low+high)/2;
            
            /* if mid is odd indexed that means the actual position is even position
               so do mid-- so that mid will become even (odd in actual position)
               
               else if mid is even(odd in actual position) then let it go
            */
            if(mid%2==1) mid--;
            
            // if element at odd(atual) position is not equal to elemnt at even(atual) position then that means
            // either element at mid or element at left side of mid could be single element
            if(nums[mid]!=nums[mid+1])
                high = mid;
            
            // if nums[mid]==nums[mid+1] that means till mid+1 position we don't have any single element so do lo = mid+2;
            else
                low = mid+2;
            
        }
        
        // low==high so return either this is our answer
        return nums[low];
    }
}
