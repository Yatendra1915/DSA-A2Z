class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = -1;
        int j = -1;
        int n = nums.length;

        int maxLen = 0;

        while(i<n-1){

            boolean acquire = false;
            boolean release = false;

            while(i<n-1){

                i++;
                acquire = true;

                if(nums[i]==0){
                    k--;
                }
                if(k<0){
                    break;
                }

                maxLen = Math.max(maxLen,i-j);

            }

            while(j<i){

                j++;
                release = true;

                if(nums[j]==0){
                    k++;
                    break;
                }
            }

            if(!acquire && !release)
                break;

        }

        return maxLen;
        
    }
}
