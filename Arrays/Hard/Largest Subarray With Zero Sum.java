class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        int prefix=0;
        int maxLen=0;
        
        for(int i=0;i<n;i++){
            prefix+=arr[i];
            
            if(hm.containsKey(prefix)){
                maxLen=Math.max(maxLen,i-hm.get(prefix));
            }
            else{
                hm.put(prefix,i);
            }
        }
        
        return maxLen;
    }
}
