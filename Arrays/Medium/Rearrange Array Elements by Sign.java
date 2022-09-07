class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        /*
          Approach 
          use two pointers i=0 for positives j=1 for negatives and initialise result array and store the elements 
          int array one by one accourding to the given conditions
        */
        int i=0;
        int j=1;
        
        int[] res = new int[nums.length];
        
        for(int k=0;k<nums.length;k++){
            
            if(nums[k]>0){
                res[i]=nums[k];
                i=i+2;
            }
            else{
                res[j]=nums[k];
                j=j+2;
            }
        }
        
        return res;
    }
}
