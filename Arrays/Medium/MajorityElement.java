class Solution {
    public int majorityElement(int[] nums) {
        
        int count=1;
        int majEle = nums[0];
        // Moore voting algo;
        
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==majEle){
                count++;
            }
            else if(count==0){
                count=1;
                majEle=nums[i];
            }
            else{
                count--;
            }
            
        }
        
        return majEle;
    }
}
