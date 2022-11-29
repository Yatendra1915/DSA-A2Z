class Solution{

    int count;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    count=0;
	    
	    helper(arr,n,sum,0,0);
	        
	    return count;
	} 
	
	public void helper(int[] arr,int n, int sum ,int idx, int temp){
	    
	    if(idx == n){
	        
	        if(sum==temp){
	            count++;
	        }
	        return;
	    }
	    
	    helper(arr,n,sum,idx+1,temp);
	    
	    temp+=arr[idx];
	    helper(arr,n,sum,idx+1,temp);
	    temp-=arr[idx];
	    
	    return;
	}
}
