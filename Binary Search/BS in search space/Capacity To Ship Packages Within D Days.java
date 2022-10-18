class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low=1;
        int high=0;
        
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }
        
        int ans=0;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            if(isValid(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
        
        return ans;
    }
    
 
    public boolean isValid(int[] weights,int days,int capacity){
        
        int ans=1;
        int temp=0;
        for(int i:weights){
            
            if(temp+i>capacity){
                temp=0;
                ans++;
            }
            temp+=i;
        }
        
        return ans<=days;
    }
}
