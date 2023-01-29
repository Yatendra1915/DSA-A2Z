class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int i=-1;
        int j=-1;
        int n = s.length();
        int len = -1;
        
        while(true){
            
            boolean acquire=false;
            boolean release=false;
            
            while(i<n-1){
                i++;
                acquire = true;
                
                char ch = s.charAt(i);
                
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                
                if(hm.size()==k){
                    len = Math.max(len,i-j);
                }
                
                if(hm.size()>k){
                    break;
                }
            }
            
            while(j<i){
                
                j++;
                release=true;
                
                char ch = s.charAt(j);
                
                hm.put(ch,hm.get(ch)-1);
                
                if(hm.get(ch)==0){
                    hm.remove(ch);
                }
                
                if(hm.size()==k){
                    break;
                }
            }
            
            if(!release && !acquire)
                break;
            
        }
        
        return len;
    }
}
