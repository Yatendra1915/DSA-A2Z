class Solution{
    
  /*
    N = 7, x = 5 
    arr[] = {1,2,8,10,11,12,19}
    Output: 1
    Explanation: Largest Number less than 5 is 2 (i.e K = 2), whose index is 1(0-based indexing).
  */
    static int findFloor(long arr[], int n, long x)
    {
        
        int low = 0;
        int high= n-1;
        
        while(low<=high){
            
            int mid = (high+low)/2;
            
            if(arr[mid]==x)
                return mid;
                
            else if(arr[mid]<x && mid<n-1 && arr[mid+1]>x || arr[mid]<x && mid==n-1)
                return mid;
            else if(arr[mid]<x){
                low = mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            
        }
        
        return -1;
    }
    
}
