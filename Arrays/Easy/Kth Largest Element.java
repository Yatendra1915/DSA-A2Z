class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        return quickSelect(nums,0,len-1,len-k);
    }
    public int quickSelect(int[] nums,int low,int high,int k){

        if(low>high){
            return -1;
        }
        //recursive case
        int p=partition(nums,low,high);
        if(p==k){
            return nums[p];
        }
        else if(p<k){
            return quickSelect(nums,p+1,high,k);
        }
        else{
            return quickSelect(nums,low,p-1,k);
        }
    }
    
    public int partition(int[] arr,int low,int high){

    int i=low;
    int j=low;
  
    int pivot = arr[high];
  
    while(i<=high){
        
        if(pivot>=arr[i]){
          
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
          
            i++;j++;
        }
        else{
            i++;
        }
    
    }
  
    return j-1;
   }

}
