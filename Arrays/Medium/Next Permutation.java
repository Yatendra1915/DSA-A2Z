class Solution {
  
    /*
        find peak-1 index;
        
        if(peak-1>=0)
        find element which is just greater than peak-1;
        swap(that element,peak-1 element)
        
        at last reverse(peak+1,n-1)
    */
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        
        int i = n-2;
        
        while(i>=0 && nums[i+1]<=nums[i]) i--;
        
        if(i>=0){
            
            int j= n-1;
            
            while(nums[j]<=nums[i]) j--;
            
            swap(nums,i,j);
            
        }
        
        reverse(nums,i+1,n-1);
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
