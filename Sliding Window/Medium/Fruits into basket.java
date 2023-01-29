class Solution {
    public static int totalFruits(int N, int[] fruits) 
    {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int i= -1 ;
        int j= -1;
        
        
        
        int maxFruits=0;
        while(true){
            
            boolean acquire = false;
            boolean release = false;
            
            while(i<N-1){
                
                i++;
                acquire = true;
                
                int fruit = fruits[i];
                
                hm.put(fruit,hm.getOrDefault(fruit,0)+1);
                
                if(hm.size()>2){
                    break;
                }
                
                
                    
                maxFruits=Math.max(maxFruits,i-j);
                
                
            }
            
            while(j<i){
                
                j++;
                release = true;
                
                int fruit = fruits[j];
                
                hm.put(fruit,hm.get(fruit)-1);
                
                if(hm.get(fruit)==0){
                    hm.remove(fruit);
                    break;
                }
            }
            
            if(!release && !acquire)
                break;
            
        }
        
        return maxFruits;
    } 
}
