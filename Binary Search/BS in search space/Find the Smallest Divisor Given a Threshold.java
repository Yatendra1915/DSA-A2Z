class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int min = 1;
        int max = -1;
        
        for(int i: nums){
            max=Math.max(max,i);
        }
        
        int smallestDivisor = -1;
        
        while(min<=max){
            
            int mid = min + (max-min)/2;
            
            if(isValid(nums,threshold,mid)){
                
                smallestDivisor=mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        
        return smallestDivisor;
    }
    
    public boolean isValid(int[] nums,int threshold,int divisor){
        
        int result=0;
        
        for(int i:nums){
            result+=(int)Math.ceil((double)i/divisor);
        }
        
        return result<=threshold;
    }
}
