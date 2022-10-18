class Solution
{
    public int NthRoot(int n, int m)
    {
      
        int low = 1;
        int high = m;
        
        while(low<=high){
            
            int mid = (low+high)/2;
            
            int mult = (int)Math.pow(mid,n);
            
            if(mult == m)
                return mid;
            
            else if(mult<m)
                low = mid+1;
                
            else
                high=mid-1;
        }
        
        return -1;
    }
    
}
