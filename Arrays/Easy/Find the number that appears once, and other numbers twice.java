class Solution {
    public int singleNumber(int[] nums) {
        
        // take xor of all elements two duplicates will cancel with each other at last only one elemnt remains
        int x=0;
        
        for(int n:nums){
            x=n^x;
        }
        
        return x;
    }
}
