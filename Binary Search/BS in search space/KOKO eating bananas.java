class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 0;
        int max = 0;
        
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        
        int k = max;
        
        while(min<=max){
            
            int mid = min + (max-min)/2;
            
            if(canEat(piles,h,mid)){
                k = Math.min(k,mid);
                max = mid-1;
            }
            else
                min = mid+1;
            
        }
        
        return k;
    }
    
    public boolean canEat(int[] piles,int h ,int k){
        
        int count = 0;
        
        for(int pile:piles){
            
            count+=(int)Math.ceil(pile*1.0/k);
            
            
        }
        
        return count<=h;
    }
}
