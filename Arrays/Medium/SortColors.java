class Solution {
    public void sortColors(int[] nums) {
        
        // idea is to create 2 partitions which will segregate 0's 1's and 2's
        //we'll use simple three pointer approach for this
        // low will represent the index upto which all 1's are sorted;
        //mid will be used for traversal of array;
        //high will represent the index after which all 2's are sorted;
        
        
        int low=0;
        int high=nums.length-1;
        int mid=0;
        
        while(mid<=high){
            //if nums[mid]==0 then swap the ele with low;
            //now increase mid++ and low++ the length of 1'st partition is increased by low++
            //and we increased mid++ for simple traversal;
            if(nums[mid]==0){
                
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                mid++;low++;
            }
            
            //if nums[mid] == 1 then simply increase mid++
            //because once all 0 and 2 are sorted 1's will be automatically sorted
            else if(nums[mid]==1){
                mid++;
            }
            // if nums[mid]==2 then put the elemnt in 2's partition and
            // decrese the index(that is increase the size of partition of 2)
            //we didn't change the index of mid because we hae to see if swapped element is 0 or 1 or 2
            else{
                int temp =nums[high];
                nums[high]=nums[mid];
                nums[mid]=temp;
                high--;
            }
            
        }
    }
}
