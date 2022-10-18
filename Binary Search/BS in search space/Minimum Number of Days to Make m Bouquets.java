class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        
        for(int day:bloomDay){
            minDay = Math.min(minDay,day);
            maxDay = Math.max(maxDay,day);
        }
        
        int MinimumDaysRequired = -1;
        while(minDay<=maxDay){
            
            int mid = minDay + (maxDay-minDay)/2;
            
            if(ifBloom(bloomDay,m,k,mid)){
                MinimumDaysRequired = mid;
                maxDay = mid-1;
            }
            else
                minDay = mid+1;
            
        }
        
        return  MinimumDaysRequired;
    }
    
    public boolean ifBloom(int[] bloomDay,int m,int k,int currDay){
        
        
        int bouquets = 0;
        int n = bloomDay.length;
        for(int i=0;i<n;i++){
            
            int count = 0;
            while(i<n && bloomDay[i]<=currDay){
                
                count++;
                i++;
                
            }
            
            bouquets+= count/k;
        }
        
        return bouquets>=m;
    }
}
