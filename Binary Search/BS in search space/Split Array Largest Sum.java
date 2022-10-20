class Solution {
    public int splitArray(int[] nums, int k) {
        
        int min = 0;
        int max = 0;
        
        for(int i:nums){
            min=Math.max(min,i);
            max+=i;
        }
        
        int res = -1;
        while(min<=max){
            
            int mid = min + (max-min)/2;
            
            
            if(isPossible(nums,k,mid)){
                res = mid;
                max = mid-1;                        
            }
          
            // if our count of nummber of subarrays created with given mid is more that means mid is less 
            // so increase min to mid+1;
            else{
                min = mid+1;
            }
            
        }
        
        return res;
    }
    
    public boolean isPossible(int[] nums,int k ,int sum){
        
        int countSumOfSubarray = 0;
        int totalSubarraysOfGivenSum = 1;
        
        for(int i:nums){
            
            countSumOfSubarray+=i;
            
            if(countSumOfSubarray>sum){
                totalSubarraysOfGivenSum++;
                countSumOfSubarray=i;
            }
                
        }
        
        // if totalsubarrays is < k that means our sum is too large because of which we aren't able to
        // create required subarrays so decrease sum so do max = mid-1 to make more subarrays;
        return totalSubarraysOfGivenSum<=k;
    }
}
