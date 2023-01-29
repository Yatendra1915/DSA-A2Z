class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        int ans = 0;

        for(int i=0;i<nums.length;i++){

            sum+=nums[i];

            if(hm.containsKey(sum-goal)){
                ans+=hm.get(sum-goal);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);

        }

        return ans;
    }
}
