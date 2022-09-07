class Solution {
  
    // Approach 1 using hash map
    // TC O(N) , SC = O(N)
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            int temp = target-nums[i];
            
            if(hm.containsKey(temp)){
                return new int[]{i,hm.get(temp)};
            }
            
            hm.put(nums[i],i);
        }
        
        return new int[]{-1,-1};
    }
    
    //APPROACH 2 BY COMPARATOR BASED SORTING
    // TC = O(log(n)),SC = O(N)
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; ++i) {
            
            arr[i][0] = nums[i];
            arr[i][1] = i;
            
        }
        
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[] arr,int[] brr){
                return arr[0]-brr[0];
            }
        }); // Sort arr in increasing order by their values.
        int left = 0, right = n - 1;
        
        while (left < right) {
            
            int sum2 = arr[left][0] + arr[right][0];
            
            if (sum2 == target)
                return new int[]{arr[left][1], arr[right][1]};
            if (sum2 > target)
                right -= 1; // Try to decrease sum2
            else
                left += 1; // Try to increase sum2
        }
        return new int[]{};
    }
}
