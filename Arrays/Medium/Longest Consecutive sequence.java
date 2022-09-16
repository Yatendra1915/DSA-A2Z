class Solution {
    
    // Brute TC = O(NlogN),  SC = O(1)
    public int longestConsecutive(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        Arrays.sort(nums);
        
        int prev = nums[0];
        int maxLen=1;
        int len =1;
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==prev){
                continue;
            }
            else if(nums[i]==prev+1){
                prev=nums[i];
                len++;
                maxLen=Math.max(maxLen,len);
            }
            else{
                prev=nums[i];
                len=1;
            }
        }
        
        return maxLen;
        
    }
    
    //Optimal  TC =  O(N) , SC = O(N)
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i:nums){
            set.add(i);
        }
        
        int maxLen=0;
        
        for(int i:nums){
            
            if(!set.contains(i+1)){
                
                int n = i;
                int len=0;
                
                while(set.contains(n)){
                    n--;
                    len++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        
        return maxLen;
    }
    
}
