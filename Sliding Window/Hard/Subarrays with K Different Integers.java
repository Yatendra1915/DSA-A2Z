class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return NoOfSubarrayWithAtMost(nums,k)-NoOfSubarrayWithAtMost(nums,k-1);
    }

    private int NoOfSubarrayWithAtMost(int[] nums,int k){

        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        int j=0;
        for(int i=0;i<nums.length;i++){

            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);

            while(hm.size()>k){
                int temp = nums[j];
                hm.put(temp,hm.get(temp)-1);

                if(hm.get(temp)==0){
                    hm.remove(temp);
                }
                j++;
            }
            count+=i-j+1;

        }

        return count;
    }
}
